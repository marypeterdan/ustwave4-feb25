function validateAge(age)
{
    if (age<18)
        return false;
    else
    return true
}

//defining function - which is having call back function
function processVoterList(username, fun1, age)
{
    
  if (fun1(age))
  {
     console.log(`Hi ${username} your voter id is procssed`)
  }
  else
  console.log(`Hi ${username} You are not a major`);
}

//calling function - Invoking
processVoterList("vishak",validateAge, 14)