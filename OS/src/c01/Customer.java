package c01;/*  Customer.java
 *
 *  The Customer Thread's main activities are call the methods in Barbershop class.
 *
 *
 *  @author: 	   Jie Zhang
 *  Last Updated: 07/19/2002
 */

public class Customer extends Thread{

	private BarberShopApplet tapplet;
	private BarberShop shop;
	private int cid;
	int delay 		= 2500;
	int status		= 0;
	int cutFinish 	= 0;
	int barberID 	= 0;
	int paid 		= 0;

	public Customer(BarberShopApplet applet, BarberShop iq, int id){
		shop	 = iq;
		tapplet  = applet;
		cid 	 = id;
	}

	public void run(){

		 try{

			  status = 0;
			  tapplet.mc.println(status, "c", cid);

			  shop.sitSofa(tapplet, cid);
			  sleep(delay);
			  shop.sitBarberChair(tapplet, cid);
			  shop.waitPay(tapplet, cid);

			} catch(InterruptedException e){
				System.err.println("Customer Exception " +  e.toString());
			}
	}

}

