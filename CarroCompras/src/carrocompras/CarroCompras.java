/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrocompras;

import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class CarroCompras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <Cliente> clientes = new ArrayList();
        ArrayList <Carro> carritos = new ArrayList();
        ArrayList <Producto> catalogo = new ArrayList();
        
        int x, y, z, p, selector;
        float suma=0.0f;
        boolean bandera=true, bandera2=true;
        
        //Administrador
        
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "Metroid Dread", 100 + (float)(Math.random()*1000)));
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "Halo Infinite", 100 + (float)(Math.random()*1000)));
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "Mortal Kombat 10", 100 + (float)(Math.random()*1000)));
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "Audífonos Skul candy", 100 + (float)(Math.random()*1000)));
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "Play Station 5", 100 + (float)(Math.random()*1000)));
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "Xaomi Mi watch", 100 + (float)(Math.random()*1000)));
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "Arbol de navidad", 100 + (float)(Math.random()*1000)));
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "PC gaming", 100 + (float)(Math.random()*1000)));
        catalogo.add(new Producto(10 + (int)(Math.random()*40), "Samsung Galaxy S10+", 100 + (float)(Math.random()*1000)));
        
        //registrar un cliente
        
        Cliente c1 = new Cliente("Jacob", "jacob@ipn.mx");
        Cliente c2 = new Cliente("Calypso", "calypso@ipnmx");
        Cliente c3 = new Cliente("Kelly", "kelly@ipnmx");
        
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        
        //Carros
        
        Carro ca1 = new Carro(123, "Carro 1");
        Carro ca2 = new Carro(456, "Carro 2");
        Carro ca3 = new Carro(789, "Carro 3");
        
        carritos.add(ca1);
        carritos.add(ca2);
        carritos.add(ca3);
        
        //asignando carritos
        c1.asignarCarro(ca1);
        c2.asignarCarro(ca2);
        c3.asignarCarro(ca3);
        
        
        while(bandera){
            
            x=Ventanas.cuadroIndex(clientes);
            if(x>=0 && x<4){
                bandera2 = true;
                while(bandera2){
                    selector = Ventanas.cuadroIndex(clientes.get(x-1).getCarro());
                    switch(selector){
                        case 1:
                            y = Ventanas.cuadroDeAccion(Producto.showProducts(catalogo));
                            if(y!=-1){
                                z=Ventanas.cuadroCantidad();
                                if(z<=catalogo.get(y-1).getCantidad()){
                                    clientes.get(x-1).getCarro().agregar(catalogo.get(y-1), z);
                                    catalogo.get(y-1).setCantidad(catalogo.get(y-1).getCantidad()-z);
                                    bandera2=true;   
                                }else{
                                    Ventanas.CuadroDeTexto("No hay suficientes productos en el almacén", 2);
                                }
                            }else{
                                bandera2=false;
                            }
                        break;
                        
                        case 2:
                            for(Producto i: catalogo){
                                for(Item j: clientes.get(x-1).getCarro().getArticulos()){
                                    if(i.getNombre().equals(j.getProducto().getNombre())){
                                        i.setCantidad(i.getCantidad()+j.getCantidad());
                                    }
                                }
                            }
                            
                            clientes.get(x-1).getCarro().clear();
                            Ventanas.CuadroDeTexto("se ha vaciado tu carrito de compras", 0);
                        break;
                        
                        case 3:
                            y = Ventanas.cuadroDeAccion(clientes.get(x-1).getCarro().showProducts(1));
                            if(y<=clientes.get(x-1).getCarro().getArticulos().size()){
                                p = clientes.get(x-1).getCarro().getArticulos().get(y-1).getCantidad();
                                z = Ventanas.cuadroCantidad();
                                for(Producto i: catalogo){
                                    for(Item j: clientes.get(x-1).getCarro().getArticulos()){
                                        if(i.getNombre().equals(j.getProducto().getNombre()) && z<=i.getCantidad()){
                                            if(z<=p){
                                                i.setCantidad(i.getCantidad()+(p-z));
                                                clientes.get(x-1).getCarro().getArticulos().get(y-1).setCantidad(z);
                                            }else{
                                                i.setCantidad(i.getCantidad()-(z-p));
                                                clientes.get(x-1).getCarro().getArticulos().get(y-1).setCantidad(z);
                                            }  
                                        }else if(i.getNombre().equals(j.getProducto().getNombre()) && z>i.getCantidad()){
                                            Ventanas.CuadroDeTexto("No hay suficientes productos en el almacén", 2);
                                        }
                                    }
                                } 
                            }else{
                                Ventanas.CuadroDeTexto("valor insertado fuera de rango", 2);
                            }
                            
                            
                            //clientes.get(x-1).getCarro().getArticulos()
                        break;
                        
                        case 4:
                            y = Ventanas.cuadroDeAccion(clientes.get(x-1).getCarro().showProducts(1));
                            if(y!=-1){
                                catalogo.get(y-1).setCantidad(catalogo.get(y-1).getCantidad()+clientes.get(x-1).getCarro().getArticulos().get(y-1).getCantidad());
                                clientes.get(x-1).getCarro().retirarDelCarro(y-1);
                            }
                            
                        break;
                        
                        case 5:
                            suma=0.0f;
                            for(Item articulo: clientes.get(x-1).getCarro().getArticulos()){
                                suma+=(articulo.getProducto().getPrecio()*articulo.getCantidad());
                            }
                            Ventanas.CuadroDeTexto("Tu pedido se ha completado exitosamente, llega el sabado!!\n\n"
                                    + clientes.get(x-1).getCarro().showProducts(1) +"\n\nsubtotal: "+suma+"\n\n"
                                            + "descuento IVA 0.16%: "+suma*0.16+"\n\nTotal: "+(suma+(suma*0.16)), selector);
                            clientes.get(x-1).getCarro().clear();
                        break;
                        
                        case 6:
                            Ventanas.CuadroDeTexto("Sesion cerrada", selector);
                            bandera2=false;
                        break;
                        default: 
                            Ventanas.CuadroDeTexto("Operacion cancelada, has cerrado sesion por defecto", selector);
                            bandera2=false;
                    }
                }
            }else{
                bandera=false;
                System.exit(0);                
            }
        }
    }
    
}
