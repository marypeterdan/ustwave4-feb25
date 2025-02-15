

function display()
{

    document.getElementById("mymain").style.background="yellow"

    let username=document.getElementById("txtname").value
    if(username=="")

        document.getElementById("spa1").innerText="Invalid user"

        else
       document.getElementById("spa1").innerText="Welcome " + username

}