<?php

class AdminController extends Zend_Controller_Action {

    protected $_adminModel;
    protected $_authService;
    protected $_form;
    protected $_updateForm;

    public function init() {
        $this->_helper->layout->setLayout('admin');
        $this->_adminModel = new Application_Model_Admin();
        $this->_catalogModel = new Application_Model_Catalog();
        $this->view->productForm = $this->getProductForm();
        $this->_updateForm = new Application_Form_Admin_Product_Update();
        $this->_authService = new Application_Service_Auth();
    }

    public function indexAction() {
        //  $this->getIndexDetails();
    }

    public function logoutAction() {
        $this->_authService->clear();
        return $this->_helper->redirector('index', 'public');
    }

    public function newproductAction() {
        
    }

    public function addproductAction() {
        if (!$this->getRequest()->isPost()) {
            $this->_helper->redirector('index');
        }
        $form = $this->_form;
        if (!$form->isValid($_POST)) {
            $form->setDescription('Attenzione: alcuni dati inseriti sono errati.');
            return $this->render('newproduct');
        }
        $values = $form->getValues();
        $this->_adminModel->saveProduct($values);

        $this->_helper->redirector('index');
    }

    public function delproductAction() {

        $this->getIndexDetails();

        $id = $this->_getParam('productId', 0);
        $this->_adminModel->deleteProduct($id);
    }

    public function updateproductAction() {

        $this->getIndexDetails();
    }

    public function updateformAction() {


        $this->getProductDataToModify();

        $productId = $this->_getParam('productId', null);


        if ($this->getRequest()->isPost()) {
            $formData = $this->getRequest()->getPost();
            if ($this->_updateForm->isValid($formData)) {

                $modifyingProduct = array(
                    'name'          => $this->_updateForm->getValue('productName'),
                    'descLong'      => ' <p> ' . $this->_updateForm->getValue('productDescLong') . ' </p> ',
                    'descShort'     => $this->_updateForm->getValue('productDescShort'),
                    'price'         => $this->_updateForm->getValue('productPrice'),
                    'image'         => $this->_updateForm->getValue('image'),
                    'discountPerc'  => $this->_updateForm->getValue('discountPerc'),
                    'discounted'    => $this->_updateForm->getValue('discounted')
                );

                $this->_adminModel->editProduct($productId, $modifyingProduct);
                $this->_helper->redirector('updateproduct');
                
            } else {
                $this->_updateForm->populate($formData);
            }
        }

        $this->view->form = $this->_updateForm;
    }

// Validazione AJAX
    public function validateproductAction() {
        $this->_helper->getHelper('layout')->disableLayout();
        $this->_helper->viewRenderer->setNoRender();

        $prodform = new Application_Form_Admin_Product_Add();
        $response = $prodform->processAjax($_POST);
        if ($response !== null) {
            $this->getResponse()->setHeader('Content-type', 'application/json')->setBody($response);
        }
    }

    private function getProductForm() {
        $urlHelper = $this->_helper->getHelper('url');
        $this->_form = new Application_Form_Admin_Product_Add();
        $this->_form->setAction($urlHelper->url(array(
                    'controller' => 'admin',
                    'action' => 'addProduct'), 'default'
        ));
        return $this->_form;
    }

      /*
      private function getUpdateProductForm() {
            $urlHelper = $this->_helper->getHelper('url');
            $this->_updateForm = new Application_Form_Admin_Product_Update();
            $this->_updateForm->setAction($urlHelper->url(array(
            'controller' => 'admin',
            'action' => 'updateproduct'), 'default'
            ));
            return $this->_updateForm;
      }
      
     */

    private function getProductDataToModify() {

        $productName = $this->_getParam('productName', null);
        $productDescShort = $this->_getParam('productDescShort', null);
        $productDescLong = $this->_getParam('productDescLong', null);
        $productPrice = $this->_getParam('productPrice');
        $discountPerc = $this->_getParam('discountPerc', null);
        $image = $this->_getParam('image', null);

        $this->_updateForm->productName->setValue($productName);
        $this->_updateForm->productDescShort->setValue($productDescShort);
        $this->_updateForm->productDescLong->setValue($productDescLong);
        $this->_updateForm->productPrice->setValue($productPrice);
        $this->_updateForm->image->setValue($image);
        $this->_updateForm->discountPerc->setValue($discountPerc);
    }

    private function getIndexDetails() {
        
        $topCats = $this->_catalogModel->getTopCats();

        $topId = $this->_getParam('selTopCat', null);
        if (!is_null($topId)) {
            $subCats = $this->_catalogModel->getCatsByParId($topId);
        } else {
            $subCats = null;
        }

        $cat = $this->_getParam('selCat', null);
        $paged = $this->_getParam('page', 1);
        if (!is_null($cat)) {

            $prods = $this->_catalogModel->getProdsByCat($cat, $paged, $order = null, $deep = false);
        } elseif (!is_null($topId)) {

            $prods = $this->_catalogModel->getDiscProds($topId, $paged, $order = array('discountPerc DESC'), $deep = true);
        } else {

            foreach ($topCats as $topCat) {
                $topCatsList[] = $topCat->catId;
            }
            $prods = $this->_catalogModel->getDiscProds($topCatsList, $paged, $order = array('discountPerc DESC'), $deep = true);
        }
        $this->view->assign(array(
            'topCategories' => $topCats,
            'selectedTopCat' => (is_null($topId) ? null : $this->_catalogModel->getCatById($topId)->name),
            'subCategories' => $subCats,
            'products' => $prods
                )
        );
    }

}

