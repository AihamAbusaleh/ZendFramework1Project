<?php

class Application_Form_Admin_Product_Update extends App_Form_Abstract {

    public function init() {
        $this->setName('EditForm');

        $id = new Zend_Form_Element_Hidden('id');

/*
        $productName = new Zend_Form_Element_Text('productName');
        $productName->setLabel('Nome')
                ->setDecorators($this->elementDecorators)
                ->setValidators(array(array('StringLength', true, array(1, 25))))
                ->setRequired(true)
                ->addFilter('StringTrim');

*/
  $this->addElement('text', 'productName', array(
            'label' => 'Nome',
            'filters' => array('StringTrim'),
            'required' => true,
            'validators' => array(array('StringLength', true, array(1, 25))),
            'decorators' => $this->elementDecorators,
        ));

        $this->addElement('text', 'productDescShort', array(
            'label' => 'Descrizione Breve',
            'required' => true,
            'filters' => array('StringTrim'),
            'validators' => array(array('StringLength', true, array(1, 30))),
            'decorators' => $this->elementDecorators,
        ));

        $this->addElement('select', 'discounted', array(
            'label' => 'In Sconto',
            'multiOptions' => array('1' => 'Si', '0' => 'No'),
            'decorators' => $this->elementDecorators,
        ));
  $this->addElement('text', 'discountPerc', array(
            'label' => 'Sconto (%)',
            'value' => 0,
            'required' => true,
            'validators' => array('Int'),
            'decorators' => $this->elementDecorators,
        ));
        $this->addElement('text', 'productPrice', array(
            'label' => 'Prezzo',
            'required' => true,
            'filters' => array('LocalizedToNormalized'),
            'validators' => array(array('Float', true, array('locale' => 'en_US'))),
            'decorators' => $this->elementDecorators,
        ));


        $this->addElement('file', 'image', array(
            'label' => 'Immagine',
            'destination' => APPLICATION_PATH . '/../public/images/products',
            'validators' => array(
                array('Count', false, 1),
                array('Size', false, 102400),
                array('Extension', false, array('jpg', 'gif', 'png'))),
            'decorators' => $this->fileDecorators,
        ));

        $this->addElement('textarea', 'productDescLong', array(
            'label' => 'Descrizione Estesa',
            'cols' => '60', 'rows' => '20',
            'filters' => array('StringTrim'),
            'required' => true,
            'validators' => array(array('StringLength', true, array(1, 2500))),
            'decorators' => $this->elementDecorators,
           
        ));
        
      
        $this->addElement('submit', 'add', array(
            'label' => 'Modifica Prodotto',
            'decorators' => $this->buttonDecorators,
        ));

        $this->setDecorators(array(
            'FormElements',
            array('HtmlTag', array('tag' => 'table')),
            array('Description', array('placement' => 'prepend', 'class' => 'formerror')),
            'Form'
        ));



     //   $this->addElements(array( $productName));
    }

}
