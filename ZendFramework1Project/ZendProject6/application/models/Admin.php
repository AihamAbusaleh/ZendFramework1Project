<?php

class Application_Model_Admin extends App_Model_Abstract {

    public function __construct() {
        
    }

    public function getSubCats() {
        return $this->getResource('Category')->getSubCats();
    }

    public function saveProduct($info) {
        return $this->getResource('Product')->insertProduct($info);
    }

    public function getUserByName($info) {
        return $this->getResource('User')->getUserByName($info);
    }

    public function deleteProduct($id) {
        return $this->getResource('Product')->delProduct($id);
    }
/*
    public function editProduct($id, $productName, $productDescLong, $productDescShort, $productPrice, $discounted, $discountPerc,$image) {
        return $this->getResource('Product')->updateProduct($id, $productName, $productDescLong, $productDescShort, $productPrice, $discounted, $discountPerc,$image);
    }
*/
    
     public function editProduct($id, $modifyingProduct) {
        return $this->getResource('Product')->updateProduct($id, $modifyingProduct );
    }
}