class Customer{

public customerId : number=0;
public customerName : string="";
public customerCity : string="";

constructor(customerId:number=0,customerName:string="",customerCity:string=""){
    this.customerId=customerId;
    this.customerName=customerName;
    this.customerCity=customerCity
}

public showDetails():void
    {
       console.log(`customerId : ${this.customerId},customerName : ${this.customerName},customerCity:${this.customerCity}`);
     // console.log("Student Id : " + this.customerId);
     // console.log("Student Id : " + this.customerName);
     // console.log("Student Id : " + this.customerCity);
  

    }
}
let c1:Customer =new Customer();
let c2:Customer =new Customer(657,"Amol","warora");
let c3:Customer =new Customer(866);
let c4:Customer =new Customer(879,"Amol");

c1.showDetails();
c2.showDetails();
c3.showDetails();
c4.showDetails();




