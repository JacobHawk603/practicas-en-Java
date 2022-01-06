package carritodecompras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class CarritoCompras {

    public static void main(String[] args) {
        
        // TODO code application logic here
        ArrayList <Cliente> Clientes = new ArrayList();
        ArrayList <Producto> Catalogo =new ArrayList();
        
        //Declaracion de clientes
        Clientes.add(new Cliente((byte)1, "José Rodríguez", 1520.50F));
        Clientes.get(0).asignarCarrito(new Carrito());
        Clientes.add(new Cliente((byte)2, "Fernanda Rojas", 460F));
        Clientes.get(1).asignarCarrito(new Carrito());
        Clientes.add(new Cliente((byte)3, "Mario Hernández", 5820.35F));
        Clientes.get(2).asignarCarrito(new Carrito());
        
        //Declaración de productos
        Catalogo.add(new Producto((byte)1,"Calcetines",150.45F,"Paquete 5 calcetines",25,"Ropa, Zapatos y Accesorios"));
        Catalogo.add(new Producto((byte)2,"Smartphone Samsung",3499.99F,"64 GB 3GB RAM",6,"Electronicos"));
        Catalogo.add(new Producto((byte)3,"Llantas para camioneta",549F,"LLantas para camioneta rodada 45",2,"Auto"));
        Catalogo.add(new Producto((byte)4,"Reloj Watch",129.55F,"Marca ",3,"Ropa, Zapatos y Accesorios"));
        Catalogo.add(new Producto((byte)5,"Chabacanos Deshidratados",58.9F,"250 gr",1,"Abarrotes"));
        Catalogo.add(new Producto((byte)6,"Zapatos de vestir",350F,"Talla 27",4,"Ropa, Zapatos y Accesorios"));
        Catalogo.add(new Producto((byte)7,"Frasco Nescafé Grande",1050.45F,"Contenido neto: 4.5 kg",12,"Abarrotes"));
        Catalogo.add(new Producto((byte)8,"PlayStation 5",3000F,"Control y cables no incluidos",4,"Electronicos"));
        Catalogo.add(new Producto((byte)9,"Detergente Roma",10.90F,"Biodegradable",6,"Abarrotes"));
        Catalogo.add(new Producto((byte)10,"Camara fotográfica",2500F,"12 megapixeles",2,"Electronicos"));
        Catalogo.add(new Producto((byte)11,"Tapetes para auto",1250F,"De plastico color gris",5,"Auto"));
        
        int opcion,Subopc,sub,i,NumA;
        String sel;
        Cliente UsuarioActivo=null;
        String menupr,Submenu;
                  
	do{
           menupr="Elige alguno de los clientes: \n"; 
           for (i=0;i<Clientes.size();i++)
             {    Cliente c=Clientes.get(i);
                  menupr+=i+".-"+c.get_nom()+" ("+ c.get_car().get_cant()+")\n";
             }
           menupr+=Clientes.size()+".-Reporte de Ventas\n"; 
           menupr+=Clientes.size()+1+".-Salir";
                   
	   // Menu
	   do {  
               sel=JOptionPane.showInputDialog(menupr);
           }while(sel==null||sel.equals(""));	   
	   // seleccion segun
           
           opcion=Integer.parseInt(sel);
	   //Un cliente valido
	   if (opcion>=0&&opcion<Clientes.size())     			
           {  
             UsuarioActivo=Clientes.get(opcion);
             Carrito C=UsuarioActivo.get_car();  
             do{ Submenu="Bienvenido "+UsuarioActivo.get_nom()+" carro("+ UsuarioActivo.get_car().get_cant()+")\n";   
                 Submenu+="1.-Ingresar al Carro. \n2.-Agregar al Carro.\n3.-Vaciar Carro.\n4.-Hacer el Pedido.\n5.-Pedidos.\n6.-Cerrar Sesion.";
                 do {  
                 sel=JOptionPane.showInputDialog(Submenu);
                 }while(sel==null||sel.equals(""));	   
	         // seleccion segun
                 Subopc=Integer.parseInt(sel);
                 switch(Subopc){
                     case 1: 
                             Item I;
                             int ps,OpP;
                             String ContCarro,menucar,menuprod;
                             Item itm;
                             Producto pr;
                             
                             if(C.get_tam()==0){
                                 ContCarro="El Carro se encuentra Vacio";
                                 JOptionPane.showMessageDialog(null,ContCarro, "Carro de "+UsuarioActivo.get_nom(), JOptionPane.INFORMATION_MESSAGE);
                                 break;
                               } 
                            // En el caso que el carro tenga productos                       
                            do{
                              // Menu  
                              ContCarro=""; 
                              menucar="Elige un producto o regresar:\n";
                             //Mostrar el contenido del carro     
                             for (int j=0;j<C.get_tam();j++)
                              {   I=C.get_art(j);
                                  ContCarro+=j+".-"+I.get_prod().get_nom()+ " cant: "+ I.get_can()+"\n";
                              }    
                             
                             menucar+=ContCarro+C.get_tam()+".-Regresar.";
                             do {  
                                  sel=JOptionPane.showInputDialog(menucar);
                                }while(sel==null||sel.equals(""));	   
                                // seleccion segun
                             ps=Integer.parseInt(sel);
                            
                             if (ps>=0&&ps<C.get_tam()) 
                              { itm=C.get_art(ps);
                                pr=itm.get_prod();
                                menuprod=pr.get_nom()+" Cantidad: "+itm.get_can()+"\n"
                                        + "1.-Quitar el producto del carro\n2.-Cambiar la Cantidad.\n3.-Regresar";
                          
                                     do {  
                                          sel=JOptionPane.showInputDialog(menuprod);
                                        }while(sel==null||sel.equals(""));	   
                                    OpP=Integer.parseInt(sel);
                                    switch(OpP){
                                        
                                        case 1: C.quitar(ps);
                                                JOptionPane.showMessageDialog(null, "El articulo se ha quitado del carrito", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
                                                break; 
                                                
                                        case 2: int s;
                                                Item item=C.get_art(ps);
                                                Producto prod=item.get_prod();
                                                do {  
                                                    sel=JOptionPane.showInputDialog("Introduzca la cantidad a la desea cambiar: ");
                                                   }while(sel==null||sel.equals("")); 
                                                NumA=Integer.parseInt(sel);
                                                
                                                s=prod.get_stock()+item.get_can();
                                                if (NumA>0&&NumA<=s){
                                                       prod.set_stock(s-NumA);
                                                       item.set_can(NumA);
                                                       JOptionPane.showMessageDialog(null, "El articulo se ha actualizado", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);                               
                                                   }else{
                                                       JOptionPane.showMessageDialog(null, "No hay suficiente stock o la cantidad es invalida", "Operacion no exitosa", JOptionPane.ERROR_MESSAGE);
                                                   }   
                                                break; 
                                                
                                        case 3: JOptionPane.showMessageDialog(null, "Saliendo del menu", "Regresando...", JOptionPane.INFORMATION_MESSAGE);       
                                                break;
                                                
                                        default: JOptionPane.showMessageDialog(null, "Error", "Opcion Invalida", JOptionPane.ERROR_MESSAGE);          
                                                
                                      }
                                                           
                              }else if (ps==C.get_tam())
                              {
                                JOptionPane.showMessageDialog(null,"Regresando", "Carro de "+UsuarioActivo.get_nom()+ " ("+ C.get_cant()+")" , JOptionPane.INFORMATION_MESSAGE);
                              }else{
                                JOptionPane.showMessageDialog(null, "Error", "Opcion Invalida", JOptionPane.ERROR_MESSAGE);
                              }
                             
                             }while(ps!=C.get_tam());       
                            
                             break; 
                     case 2: String Cat=null;
                             Object[] possibleValues = { "Todos los departamentos", "Auto", "Ropa, Zapatos y Accesorios","Electronicos","Abarrotes" };
                             
                             String selectedValue= (String)JOptionPane.showInputDialog(null,
                                                  "Elegi un Departamento", "Catalogo",
                                                  JOptionPane.INFORMATION_MESSAGE, null,
                                                  possibleValues, possibleValues[0]); 
                             if (selectedValue==null){
                                break;
                             }  
                             // USO  de STREAMS
                             List <Producto> lista;
                             if(selectedValue.equals("Todos los departamentos")){
                                lista = Catalogo.stream().collect(Collectors.toList());
                             } else
                                //Filtrar el Catalogo por Departamento
                                lista =Catalogo.stream().filter( x->x.getDepartamento().equals(selectedValue)).collect(Collectors.toList());
                                                             
                             Cat="Elige algun de los producto: \n";
                             Producto p;
                             for (i=0;i<lista.size();i++)
                               {    p=lista.get(i);
                                    if(p.get_stock()>0){
                                    Cat+=i+".-"+p.get_nom()+" ("+ p.get_stock()+")"+" precio: "+p.get_prec()+"\n";
                                    }
                               }
                             do {  
                                  sel=JOptionPane.showInputDialog(Cat);
                                }while(sel==null||sel.equals(""));	   
                                // seleccion segun
                                sub=Integer.parseInt(sel);  
                                                                
                             if(sub>=0&&sub<lista.size()) {
                                Producto prodsel=lista.get(sub);
                                do {  
                                    sel=JOptionPane.showInputDialog("¿Cuantos?");
                                }while(sel==null||sel.equals("")); 
                                NumA=Integer.parseInt(sel); 
                                
                                if (NumA>0&&NumA<=prodsel.get_stock()){
                                    C.agregar(prodsel, NumA);
                                    JOptionPane.showMessageDialog(null, "El articulo ha sido ingresado al carro", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);                               
                                }else{
                                    JOptionPane.showMessageDialog(null, "No hay suficiente stock o la cantidad es invalida", "operacion no exitosa", JOptionPane.ERROR_MESSAGE);
                                }   
                             }  
                             break;
                     case 3: 
                             C.vaciar();
                             JOptionPane.showMessageDialog(null, "Se ha vaciado el Carro", "operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
                             break;        
                     case 4: 
                             String ticket=C.checkout();
                             JOptionPane.showMessageDialog(null, ticket ,"Pedido realizado", JOptionPane.INFORMATION_MESSAGE);
                             break;
                     case 5: 
                             StringBuffer Peds=new StringBuffer("");
                             String Mensaje;
                             ArrayList <Pedido> pedidos;
                             pedidos=UsuarioActivo.getPedidos();
                             
                             if(pedidos.isEmpty()){
                                 JOptionPane.showMessageDialog(null, "Historial Vacio" ,"Historial de Pedidos", JOptionPane.INFORMATION_MESSAGE);
                                 break;
                             }
                                                                  
                            pedidos.stream().sorted( (x,y)->y.getFecha().compareTo( x.getFecha() ) ).map(Pedido::toString).forEach(Peds::append);  
                            //Mensaje=pedidos.stream().sorted( (x,y)->y.getFecha().compareTo( x.getFecha() ) ).map(x->x.toString()).collect(Collectors.joining());
                             
                            JOptionPane.showMessageDialog(null,Peds,"Historial de Pedidos", JOptionPane.INFORMATION_MESSAGE);
                             
                             break;
                     case 6: JOptionPane.showMessageDialog(null, "Hasta pronto :D", "Sesion Cerrada", JOptionPane.INFORMATION_MESSAGE);
                             break;
                     default:        
                             JOptionPane.showMessageDialog(null, "Error", "Opcion Invalida", JOptionPane.ERROR_MESSAGE);
                 }
                 
             }while(Subopc!=6);
             
           }else if ( opcion == Clientes.size()){
             Map<String, Integer> productosVendidos = new HashMap<>();
                Clientes.forEach((cliente) -> cliente.getPedidos().forEach((pedido) -> pedido.getArticulos().forEach((articulo) -> {

                    String nombre = articulo.get_prod().get_nom();

                    if (productosVendidos.containsKey(nombre)) {
                        int cant = productosVendidos.get(nombre);
                        productosVendidos.put(nombre, articulo.get_can() + cant);
                    } else {
                        productosVendidos.put(nombre, articulo.get_can());
                    }
                }
                )));

                String mensaje = productosVendidos.entrySet().stream().sorted((producto1, producto2) -> producto2.getValue().compareTo(producto1.getValue()))
                        .map(input -> String.format("%s vendidos: %d", input.getKey(), input.getValue())).collect(Collectors.joining("\n"));
                
                JOptionPane.showMessageDialog(null, mensaje, "Informe de ventas", JOptionPane.INFORMATION_MESSAGE);

           } else if ( opcion == Clientes.size()+1)	
             JOptionPane.showMessageDialog(null, "Hasta pronto :D", "Te esperamos pronto", JOptionPane.INFORMATION_MESSAGE); 		
	    else  
	     JOptionPane.showMessageDialog(null, "Opcion no Valida", "Opcion no Valida", JOptionPane.ERROR_MESSAGE);
	
       }while ( opcion != Clientes.size()+1 );
        
       
      
    }
    
}
