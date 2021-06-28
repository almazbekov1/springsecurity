
const register = document.getElementById('MainRegister');

let url = 'http://localhost:8080/admin/';
register.addEventListener('submit',async function (event) {
    event.preventDefault()

    let email = document.getElementById('MainEmail').value;
    let password = document.getElementById('MainPassword').value;
    let firstName = document.getElementById('MainFirstName').value;
    let lastName = document.getElementById('MainLastName').value;
    let age = document.getElementById('MainAge').value;
    console.log(email);
    console.log(password);
    console.log(firstName);
    console.log(lastName);
    console.log(age);
    addUser({
        email: email,
        password: password,
        firstName: firstName,
        lastName: lastName,
        age: age
    })
    MainRedirect();
});
async function addUser(Obj) {
    let response = await fetch(url, {
        method: "POST",
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(Obj)


    })
    let answer = await response.json();
    console.log(answer);
}