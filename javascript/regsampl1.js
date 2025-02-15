
validatePhone= (phone)=>
{
  const pattern=/(\d{3})-(\d{10})$/
    
  if (pattern.test(phone))
    console.log("Valid Phone number")
else
console.log("Invalid Phone")
   
}

//validatePhone("100-12345949")

searchWord = (mailid)=>
{
   const pattern=/ust/i

   console.log(pattern.test(mailid))

}

//searchWord("rogan@cts.com")

const pattern3=/^([SM])([A-Z])([A-Z])$/i

console.log(pattern3.test("WED"));