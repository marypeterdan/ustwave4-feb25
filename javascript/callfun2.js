let fun1=function calcuDiscount(amount)
{
    if (amount<1000)
        return amount*5/100;
    else if(amount<5000)
        return amount*10/100;
    else
    return amount*20/100
}

function checkProduct(product)
{
    if (product.length<2)
        return(false)
    else
    return true;
}

function processSale(f1,f2,product,amount)
{
 if(f2(product))
 {
    let ans=f1(amount)
console.log(`Discount for ${amount} is ${ans}`);
 }
 else
 console.log("Not valid input")
}

processSale(fun1,checkProduct,'washing machine',10000)