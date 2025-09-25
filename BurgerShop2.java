import java.util.*;
class Burger{
	private String orderId;
	private String customerId;
	private String customerName;
	private int burgerQty;
	private double burgerPrice;
	private String orderStatus;
	public static final double BURGERPRICE=500;
	
	
	Burger(){}
	
	Burger(String orderId,String customerId,String customerName,int burgerQty,double burgerPrice){
		this.orderId=orderId;
		this.customerId=customerId;
		this.customerName=customerName;
		this.burgerQty=burgerQty;
		this.burgerPrice=burgerPrice;
		orderStatus="PREPARING";
		
	}
	
	public String getOrderId(){
		return orderId;
	}
	
	
	public String getCustName(int index){
		return BurgerShop2.burger[index].customerName;
	}
	
	public String getCustId(){
		return customerId;	
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public double getBurgerPrice(){
		return burgerPrice;
	}
	
	public int getBurgerQty(){
		return burgerQty;
	}
	
	public String getOrderStatus(){
		return orderStatus;
	}
	
	
	//--------------SET UPDATED QTY-------------------
	
	public void updateQty(int index,int burgerQty,double burgerPrice){
		BurgerShop2.burger[index].burgerQty=burgerQty;
		BurgerShop2.burger[index].burgerPrice=burgerPrice;
	}
	
	public void updateStatus(int index,String orderStatus){
		BurgerShop2.burger[index].orderStatus=orderStatus;
	}
		
		

}
	

class BurgerShop2{
	
	static String orderId;
	static String customerId;
	static String customerName;
	static int burgerQty;
	static double burgerPrice;
	static String orderStatus;
	public static Burger[] burger={};
	
	public static void main(String args[]){
		burgerShopContent();
		
	}
	
	public static void burgerShopContent(){
		clearConsole();
		Scanner input = new Scanner(System.in);
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                   iHungry Burger                   |");
		System.out.println("+----------------------------------------------------+");
		
		System.out.print("\n[1] Place Order");
		System.out.print("\t\t[2] Search Best Customer");
		System.out.print("\n[3] Search Order");
		System.out.print("\t[4] Search Customer");
		System.out.print("\n[5] View Orders");
		System.out.print("\t\t[6] Update Order Details");
		System.out.print("\n[7] Exit");
		
		System.out.print("\n\nEnter an option : ");
		int option=input.nextInt();
		
		switch(option){
			case 1 :
				placeOrder();
			break;
			
			case 2 :
				bestCustomer();
			break;
			
			case 3:
				searchorder();
			break;
			
			case 4:
				customerDetails();
			break;
			
			case 5:
				viewOrders();
			break;
			
			case 6:
				updateOrderDetails();
			break;
			
			case 7:
				clearConsole(); 
				System.out.println("\n\t\tYou left the program...\n"); 
				System.exit(0);
			break;
			default :
				System.out.println("\n\tInvalid option");
				System.out.print("\nDo you want to try entering another valid option : ");
				char ch=input.next().charAt(0);
				
				if(ch=='y' || ch=='Y'){
					burgerShopContent();
				}else if(ch=='n' || ch=='N'){
					clearConsole(); 
					System.out.println("\n\t\tYou left the program...\n"); 
					System.exit(0);
				}
		}
	}
	
	
	public static void placeOrder(){
		clearConsole();
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                     PLACE ORDER                    |");
		System.out.println("+----------------------------------------------------+");
		
		
		generateOrderId();
		customerIdName();
		burgerQtyPrice();
		
	}
	
	
	public static void generateOrderId(){
		Burger b1=new Burger();
		if(burger.length==0){
			orderId="B0001";
		}else{
			String tempId="B"+String.format("%04d",Integer.parseInt(burger[burger.length-1].getOrderId().substring(1))+1);
			orderId=tempId;
		}
		System.out.println("Order Id : "+orderId);
		
	}
	
	//----------CUSTOMER-ID,NAME---------------
	
	public static void customerIdName(){
		Scanner input=new Scanner (System.in);
		Burger b1=new Burger();
		L1:do{
			System.out.print("\n\nEnter the customer Id - ");
			customerId =input.next();
			
			if(!isValidCustomerId(customerId)){
				System.out.println("Invalid");
				continue L1;
			}
			
			int index=searchCustId(customerId);
			
			if(index!=-1){
				customerName=b1.getCustName(index);
				System.out.println("Customer Name - "+customerName);
			}else{
				O1:do{
					System.out.print("Customer Name - ");
					customerName=input.next();
					if(!isValidName(customerName)){
						System.out.println("Your name cannot contain any special characters or numbers.");
						continue O1;
					}
					break;
				}while(true);
			}
			break;
		}while(true);
	}
	
	
	//------------VALIDATION OF CUSTOMER-ID------------
	
	public static boolean isValidCustomerId(String customerId){
		if(customerId.charAt(0)=='0' && customerId.length()==10){
			for (int i = 0; i <customerId.length(); i++){
				if(!((customerId.charAt(i)>='0') && (customerId.charAt(i)<='9'))){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//------------VALIDATION OF CUSTOMER-ID------------
	
	public static boolean isValidName(String customerName){
		for (int i = 0; i <customerName.length(); i++)
		{
			if(!(((customerName.charAt(i)>='A') && (customerName.charAt(i)<='Z')) || ((customerName.charAt(i)>='a') && (customerName.charAt(i)<='z')))){
				return false;
			}
		}
		return true;
	}
		
	
	
	//------------SEARCH CUSTOMER-ID------------
	
	
	public static int searchCustId(String custId){
		for (int i = 0; i <burger.length; i++)
		{
			if(custId.equalsIgnoreCase(burger[i].getCustId())){
				return i;
			}
		}
		return -1;
	}
	
	
	//-------------BURGER QTY & PRICE------------------
	
	public static void burgerQtyPrice(){
		Scanner input=new Scanner(System.in);
		Burger b1=new Burger();
		
		System.out.print("Enter the burger qauntity - ");
		burgerQty=input.nextInt();
		
		burgerPrice=burgerQty*b1.BURGERPRICE;
		System.out.println("Total - "+burgerPrice);
		
		System.out.print("\nAre you confirming the order(Y/N)- ");
		char confirmation=input.next().charAt(0);
		
		if(confirmation=='Y' || confirmation=='y'){
			Burger []tempBurger=new Burger[burger.length+1];
			Burger newOrder=new Burger(orderId,customerId,customerName,burgerQty,burgerPrice);
			for (int i = 0; i <burger.length; i++)
			{
				tempBurger[i]=burger[i];
			}
			burger=tempBurger;
			burger[burger.length-1]=newOrder;
		}
		
		L2:do{
			System.out.print("\nDo you want to place another order(Y/N) : ");
			char ch=input.next().charAt(0);
				
			if(!(ch=='y' || ch=='Y' || ch=='n' || ch=='N')){
				System.out.println("Invalid input....");
				continue L2;
			}
			if(ch=='y' || ch=='Y'){
				placeOrder();
			}else if(ch=='n' || ch=='N'){
				burgerShopContent();
			}
			break;
		}while(true);
	}
	
	
	//=====================================================================//
	//------------Option 2 BEST CUSTOMER---------------
	
	public static void bestCustomer(){
		clearConsole();
		Burger b1=new Burger();
		Scanner input=new Scanner(System.in);
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                    BEST CUSTOMER                   |");
		System.out.println("+----------------------------------------------------+");
		
		dupRemove();
		
		L7:do{
			System.out.print("\t\nDo you want to home page (Y/N) :  ");
			char ch=input.next().charAt(0);
			
			if(!(ch=='y' || ch=='Y' || ch=='n' || ch=='N')){
				System.out.println("Invalid input....");
				continue L7;
			}
			if(ch=='y' || ch=='Y'){
				burgerShopContent();
			}else if(ch=='n' || ch=='N'){
				clearConsole(); 
				System.out.println("\n\t\tYou left the program...\n"); 
				System.exit(0);
			}
			break;
		}while(true);
			

	}
	
	
//-----------------------Removing Duplicates & Sorting the Totals --------------------

	public static void dupRemove(){
		
		String dupRemId[]={};
		String dupRemName[]={};
		
		for (int i = 0; i <burger.length; i++)
		{
			
			if(!searchDupRem(dupRemId,burger[i].getCustId())){
				String tempId[]=new String[dupRemId.length+1];
				String tempName[]=new String[dupRemName.length+1];
				
				for (int j = 0; j <dupRemId.length; j++)
				{
					tempId[j]=dupRemId[j];
					tempName[j]=dupRemName[j];
					
				}
				dupRemId=tempId;
				dupRemId[dupRemId.length-1]=burger[i].getCustId();
				dupRemName=tempName;
				dupRemName[dupRemName.length-1]=burger[i].getCustomerName();
			}	
		}
		
		
//-----------------------Calculating-Totals--------------------------
	
		double []total=new double[dupRemId.length];
		
		for (int i = 0; i < dupRemId.length; i++)
		{
			double tot=0;
			for (int j = 0; j <burger.length; j++)
			{
				if(dupRemId[i].equalsIgnoreCase(burger[j].getCustId())){
					if(!((burger[j].getOrderStatus()).equals("CANCELLED"))){
						tot+=burger[j].getBurgerPrice();
					}else{
						tot+=0;
					}
				}
			}
			total[i]=tot;
		}
		
//---------------------Sorting out Totals--------------------
		
		System.out.println("\n\n--------------------------------------------");
		System.out.printf("%-15s %-20s %-10s\n", "Customer Id", "Customer Name", "Total");
		
		for (int i = total.length-1; i >= 0; i--)
		{
			double max=0;
			String tempName="";
			
			for (int j = 0; j <i ; j++)
			{
				if(total[j]>total[j+1]){
					max=total[j];
					total[j]=total[j+1];
					total[j+1]=max;
					
					tempName=dupRemName[j];
					dupRemName[j] = dupRemName[j+1];
					dupRemName[j+1] = tempName;
				}
			}
			System.out.println("--------------------------------------------");
			System.out.printf("%-15s %-20s %-10s\n", dupRemId[i], dupRemName[i], total[i]);
		}
		System.out.println("--------------------------------------------");
		
		
	}
	
	//-------------------SEARCH OF DUPLICATES---------------
	
	public static boolean searchDupRem(String dupRem[],String custId){
		for (int i = 0; i <dupRem.length; i++)
		{
			if(custId.equals(dupRem[i])){
				return true;
			}
		}
		return false;
	}
	
	
//=====================================================================//
//-----------------------Option 3 Search Order------------------------
	
	public static void searchorder(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		Burger b1=new Burger();
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                     SEARCH ORDER                   |");
		System.out.println("+----------------------------------------------------+");
		
		L3:	do{
			System.out.print("Enter the order Id : ");
			String  orderID=input.next();
			
			int index = searchOrderId(orderID);
			if(index==-1){
				System.out.println("There is no any order placed by this order Id.");
			}else{
				System.out.println("+--------------------------------------------------------------------------------+");
				System.out.printf("| %-10s %-12s %-15s %-10s %-13s %-15s |\n", 
								  "Order Id", "Customer Id", "Name", "Quantity", "Order Value", "Order Status");
				System.out.println("+--------------------------------------------------------------------------------+");

				// Print order details
				System.out.printf("| %-10s %-12s %-15s %-10d %-13.2f %-15s |\n", 
									burger[index].getOrderId(), 
									burger[index].getCustId(), 
									burger[index].getCustomerName(), 
									burger[index].getBurgerQty(), 
									burger[index].getBurgerPrice(), 
									burger[index].getOrderStatus()); 
								  
				System.out.println("+--------------------------------------------------------------------------------+");

				
				}
				break;
			}while(true);
			
			L4:do{
				System.out.print("\nDo you want to try searching the order details again : ");
				char ch=input.next().charAt(0);
				
				if(!((ch=='Y') || (ch=='y') || (ch=='N') || (ch=='n'))){
					System.out.println("WRONG input. Try again");
					continue L4;
				}else
				if(ch=='y' || ch=='Y'){
					searchorder();
				}else if(ch=='n' || ch=='N'){
					burgerShopContent();
				}
				break;
			}while(true);
			
			
		}
		
	//-----------------IS ORDER ID (USED FOR OPTION (3) & (6)----------------
		
	public static int searchOrderId(String orderID){
		Burger b1=new Burger();
		for (int i = 0; i < burger.length; i++)
		{
			if(orderID.equals(burger[i].getOrderId())){
				return i;
			}
		}
		return -1;
	}
	
	
	//=====================================================================//
	//----------------OPTION(4) Search customer details--------------------
	
	public static void customerDetails(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                SEARCH CUSTOMER DETAILS             |");
		System.out.println("+----------------------------------------------------+");
		L5:do{
			System.out.print("\nEnter customer Id (phone no.) : ");
			String custId = input.next();
			
			int index=custIdSearch(custId);
			if(!isValidCustomerId(custId)){
				System.out.println("Invlid customer Id.");
				continue L5;
			}
			
			if(index == -1){
				System.out.println("\n\n\tThis ccustomer Id has note been added to system....");
			}else{
					
				System.out.println("\n\nCustomer Od   - "+burger[index].getCustId());
				System.out.println("Customer Name - "+burger[index].getCustomerName());
				
				System.out.println("\nCustomer Order Details");
				System.out.println("======================");
				
				System.out.println("\n------------------------------------------------");
				System.out.printf("%-10s %-18s %-12s","Order_Id","Order_Qauntity","Total_Value");
				System.out.println("\n------------------------------------------------");
				
				for (int i = 0; i <burger.length; i++)
				{
					if(burger[i].getCustId().equals(custId)){
						System.out.printf("\n%-10s %-18s %-12s",burger[i].getOrderId(),burger[i].getBurgerQty(),burger[i].getBurgerPrice());
					}
				}
				System.out.println("\n------------------------------------------------");
				
			}
			
			System.out.print("\nDo you want to search another custoner's details (Y/N) : ");	
			char ch=input.next().charAt(0);
				
			if(ch=='y' || ch=='Y'){
				customerDetails();
			}else if(ch=='n' || ch=='N'){
				burgerShopContent();
			}
			break;
		}while(true);
		
	}
	
	
	//----------------CUST ID SEARCH------------------
	
	public static int custIdSearch(String custId){
		for (int i = 0; i < burger.length; i++)
		{
			if(burger[i].getCustId().equals(custId)){
				return i;
			}
		}
		return -1;
	}
	
	
	//=====================================================================//
	//----------------OPTION(5) VIEW ORDER LIST----------------------------
	
	public static void viewOrders(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                   VIEW ORDER LIST                  |");
		System.out.println("+----------------------------------------------------+");
		
		System.out.println("\n[1] Delivered Order");
		System.out.println("[2] PREPARING Order");
		System.out.println("[3] CANCELLED Order");
		
		System.out.print("\nEnter an option to continue : ");
		int option = input.nextInt();
		
		switch(option)
		{
			case 1:
			{
				deliveredOrders();
				System.out.print("\nDo you want to home page (Y/N) :  ");
				char ch=input.next().charAt(0);
					
				if(ch=='y' || ch=='Y'){
					viewOrders();
				}else if(ch=='n' || ch=='N'){
					burgerShopContent();
				}
			}
			break;
			case 2:{
				preparingOrders();
				System.out.print("\nDo you want to home page (Y/N) :  ");
				char ch=input.next().charAt(0);
					
				if(ch=='y' || ch=='Y'){
					viewOrders();
				}else if(ch=='n' || ch=='N'){
					burgerShopContent();
				}
			}
			break;
			case 3:
			{
				cancelledOrders();
				System.out.print("\nDo you want to home page (Y/N) :  ");
				char ch=input.next().charAt(0);
					
				if(ch=='y' || ch=='Y'){
					viewOrders();
				}else if(ch=='n' || ch=='N'){
					burgerShopContent();
				}
			}
			break;
			
			default :{
				System.out.println("Invalid option...");
			}
		}		
		
		System.out.print("\nDo you want to try entering another valid option : ");
		char ch=input.next().charAt(0);
			
		if(ch=='y' || ch=='Y'){
			viewOrders();
		}else if(ch=='n' || ch=='N'){
			burgerShopContent();
		}
	}
	
	//-----------DELIVERED ORDERS----------------
	
	public static void deliveredOrders(){
		clearConsole();
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                  DELIVERED ORDERS                  |");
		System.out.println("+----------------------------------------------------+");
		
		System.out.println("\n\n--------------------------------------------------------------");
		System.out.printf("%-10s %-13s %-12s %-10s %-12s%n", "Order Id", "Customer Id", "Name", "Quantity", "Order Price");
		for (int i = 0; i < burger.length ; i++)
		{
			if("DELIVERED".equals(burger[i].getOrderStatus())){
				System.out.println("--------------------------------------------------------------");
				System.out.printf("%-10s %-13s %-12s %-10d %-12.2f%n",
				burger[i].getOrderId(),
				burger[i].getCustId(),
				burger[i].getCustomerName(),
				burger[i].getBurgerQty(),
				burger[i].getBurgerPrice());

			}
			
		}
		System.out.println("--------------------------------------------------------------");
		//System.out.println("\nDO you want to home page (Y/N) :  ");
		
	}
	
	
	//-----------OREPARING ORDERS----------------
	
	public static void preparingOrders(){
		clearConsole();
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                  PREPARING ORDERS                  |");
		System.out.println("+----------------------------------------------------+");
		
		System.out.println("\n\n--------------------------------------------------------------");
		System.out.printf("%-10s %-13s %-12s %-10s %-12s%n", "Order Id", "Customer Id", "Name", "Quantity", "Order Price");
		for (int i = 0; i < burger.length ; i++)
		{
			if("PREPARING".equals(burger[i].getOrderStatus())){
				System.out.println("--------------------------------------------------------------");
				System.out.printf("%-10s %-13s %-12s %-10d %-12.2f%n",
				burger[i].getOrderId(),
				burger[i].getCustId(),
				burger[i].getCustomerName(),
				burger[i].getBurgerQty(),
				burger[i].getBurgerPrice());

			}
			
		}
		System.out.println("--------------------------------------------------------------");
	}
	
	
	//-----------CANCELLED ORDERS----------------
	
	public static void cancelledOrders(){
		clearConsole();
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                  CANCELLED ORDERS                  |");
		System.out.println("+----------------------------------------------------+");
		
		System.out.println("\n\n--------------------------------------------------------------");
		System.out.printf("%-10s %-13s %-12s %-10s %-12s%n", "Order Id", "Customer Id", "Name", "Quantity", "Order Price");
		for (int i = 0; i < burger.length ; i++)
		{
			if("CANCELLED".equals(burger[i].getOrderStatus())){
				System.out.println("--------------------------------------------------------------");
				System.out.printf("%-10s %-13s %-12s %-10d %-12.2f%n",
				burger[i].getOrderId(),
				burger[i].getCustId(),
				burger[i].getCustomerName(),
				burger[i].getBurgerQty(),
				burger[i].getBurgerPrice());

			}
			
		}
		System.out.println("--------------------------------------------------------------");
	}
	
	
	//=====================================================================//
	//----------------OPTION(6) UPDATE ORDER DETAILS----------------------------
	
	public static void updateOrderDetails(){
		clearConsole();
		Scanner input=new Scanner(System.in);
		System.out.println("+-------------------------------------------------------------------+");
		System.out.println("|                        UPDATE ORDER DETAILS                       |");
		System.out.println("+-------------------------------------------------------------------+");
		
		System.out.print("\nEnter the Order Id : ");
		String orderId =input.next();
		
		int index=searchOrderId(orderId);
		if(index==-1){
			System.out.println("\nSorry,there is no any order that haas been placed by this Order Id."); 
		}else{
			if(burger[index].getOrderStatus()=="DELIVERED"){
				System.out.println("\nSorry ,this order has been delivered you cannot update this order....");
			}else if(burger[index].getOrderStatus()=="CANCELLED"){
				System.out.println("\nSorry ,this order has been cancelled you cannot do any changes this order.....");
			}else{
				System.out.println("\nOrder Id     -"+burger[index].getOrderId());
				System.out.println("Customer Id  -"+burger[index].getCustId());
				System.out.println("Name         -"+burger[index].getCustomerName());
				System.out.println("Qauntity     -"+burger[index].getBurgerQty());
				System.out.println("Order Price  -"+burger[index].getBurgerPrice());
				System.out.println("Order status -"+burger[index].getOrderStatus());
				
				System.out.println("\nWhat do you want to update ?");
				System.out.println("\t[1] Qauntity");
				System.out.println("\t[2] Status");
				
				L4:do{		
					System.out.print("\nEnter an option : ");
					int option=input.nextInt();
					
					if(option==1){
						qauntityUpadate(index);
					}else if(option==2){
						statusUpdate(index);
					}else{
						System.out.println("Invalid option");
						continue L4;
					}
					break;
				}while(true);	
			}
			
		}
		System.out.print("\n\nDo you want to try again updating the orders(Y/N) : ");
		char ch =input.next().charAt(0);
		
		if(ch=='y' || ch=='Y'){
				updateOrderDetails();
			}else if(ch=='n' || ch=='N'){
				burgerShopContent();
			}
		
	}
	
	
	//----------------Qauntity Update-----------------------
	
	public static void qauntityUpadate(int index){
		clearConsole();
		Burger b1= new Burger();
		Scanner input=new Scanner(System.in);
		System.out.println("Qauntity Update");
		System.out.println("===============");
		
		System.out.println("\nOrder Id - "+burger[index].getOrderId()+"\nCustomer Id - "+burger[index].getCustId()+"\nName - "+burger[index].getCustomerName());
		System.out.print("\nEnter your new qauntity : ");
		burgerQty=input.nextInt();
		burgerPrice=burgerQty*b1.BURGERPRICE;
		b1.updateQty(index,burgerQty,burgerPrice);
		
		System.out.println("\n\tUpdating order qauntity succcessfully....");
		System.out.println("\nNew order qauntity : "+burgerQty);
		System.out.println("New price of order "+burger[index].getOrderId()+" : "+burger[index].getBurgerPrice());
		
		//System.out.println(Arrays.toString(burgerPriceArray));
		//System.out.println(Arrays.toString(burgerQtyArray));
		
		
	}
	
	//----------------Status Update-----------------------
	
	public static void statusUpdate(int index){
		clearConsole();
		Burger b1=new Burger();
		Scanner input=new Scanner(System.in);
		System.out.println("Status Update");
		System.out.println("=============");
		
		System.out.println("\nOrder Id "+burger[index].getOrderId()+"\nCustomer Id - "+burger[index].getCustId()+"\nName - "+burger[index].getCustomerName());
		System.out.println("\n\t[1] CANCEL");
		System.out.println("\t[2] PREPARING");
		System.out.println("\t[3] DELIVERED");
		
		L5:do{
			System.out.print("\nEnter the new status of this order : ");
			int status=input.nextInt();
			
			if(status==1){
				b1.updateStatus(index,"CANCELLED");
			}else if(status==2){
				b1.updateStatus(index,"PREPARING");
			}else if(status==3){
				b1.updateStatus(index,"DELIVERED");
			}else{
				System.out.println("Invalid input");
				continue L5;
			}
			
			
			System.out.println("\n\tUpdating order status successfully....");
			
			System.out.println("\nNew order status : "+burger[index].getOrderStatus());
			break;
		}while(true);
	}
	
		
	//-------------CLEAR-CONSOLE METHOD--------------
	
	public final static void clearConsole() { 
		try { 
			final String os = 
			System.getProperty("os.name"); if 
			(os.contains("Windows")) { 
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
			} else { 
				System.out.print("\033[H\033[2J"); 
				System.out.flush(); 
			} 
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
}
	
	
	
	
