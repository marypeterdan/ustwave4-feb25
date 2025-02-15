function calcuTax(amount)
{
if (typeof amount == 'number')
{
    if(amount<12)
    {
        return "no tax"
    }
    else if (amount<20)
    {
        return "18% tax"
    }
}
else
{
        console.log("Invalid Input")
        return 0;
}

}

let ans=calcuTax("ten")

console.log(` for ten L tax is  ${ans}` )