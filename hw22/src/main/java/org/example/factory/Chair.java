package org.example.factory;

class Chair extends Furniture {
    @Override
    public void assemble() {
        System.out.println("Assembling a chair");
    }
}
