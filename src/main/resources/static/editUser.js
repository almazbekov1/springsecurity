// let userID;
//
// function getId(id) {
//  console.log(id)
//     userID = id;
// }
let idMain, firstNameMain, lastNameMain, ageMain, emailMain;
let putMethod;
let editUser;

function getUserEdit(id, firstName, lastName, age, email) {
    idMain = id;
    firstNameMain = firstName;
    lastNameMain = lastName;
    ageMain = age;
    emailMain = email;
    console.log("testGeeUser")
    let html = `        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">х</button>
                    <h4 class="modal-title">Заголовок окна</h4>
                </div>
                       <div class="modal-body">
                    <div class="container">
                                  <form role="form" class="form-horizontal" id="MainEditFinish">
                            <div class="form-group">
                                        <label for="MainFirstNameEdit" class="control-label col-md-2">First Name</label>
                                        <div class="col-md-6">
                                    <input type="text" class="form-control" id="MainFirstNameEdit" placeholder=${firstNameMain}>
<!--                                                    <p class="help-block">Некая подсказка</p>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="MainLastNameEdit" class="control-label col-md-2">Last Name</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="MainLastNameEdit" placeholder=${lastNameMain}>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="MainAgeEdit" class="control-label col-md-2">Age</label>
                                <div class="col-md-6">
                                    <input type="number" class="form-control" id="MainAgeEdit" placeholder=${ageMain}>
                                    <!--                <p class="help-block">Некая подсказка</p>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="MainEmailEdit" class="control-label col-md-2">Email</label>
                                <div class="col-md-6">
                                    <input type="email" class="form-control" id="MainEmailEdit" placeholder=${emailMain}>
                                    <!--                <p class="help-block">Некая подсказка</p>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="MainPasswordEdit" class="control-label col-md-2">Password</label>
                                <div class="col-md-6">
                                    <input type="password" class="form-control" id="MainPasswordEdit" placeholder=password>
                                    <!--                <p class="help-block">Некая подсказка</p>-->
                                </div>
                            </div>
                            <div style="padding-left: 189px" class="col-md-6">
                                <select class="form-control ">
                                    <option>User</option>
                                    <option>Admin</option>
                                </select>
                            </div>
                            <br><br>
                            <div style="padding-left: 189px">
                                <button type="submit" class="btn btn-success"  >Edit</button>
                            </div>
                        </form>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-danger" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
`;
    document.querySelector("#EditModal").insertAdjacentHTML("afterbegin", html);


    editUser = document.getElementById('MainEditFinish');
    editUser.addEventListener('submit', async function (event) {
        event.preventDefault()
        let emailEdit = document.getElementById('MainEmailEdit').value;
        let passwordEdit = document.getElementById('MainPasswordEdit').value;
        let firstNameEdit = document.getElementById('MainFirstNameEdit').value;
        let lastNameEdit = document.getElementById('MainLastNameEdit').value;
        let ageEdit = document.getElementById('MainAgeEdit').value;
        const someData = {
            email: getTest(emailEdit, email),
            password: getTest(passwordEdit, passwordEdit),
            firstName: getTest(firstNameEdit, firstName),
            lastName: getTest(lastNameEdit, lastName),
            age: getTest(ageEdit, age)
        }

        function getTest(name1, name2) {
            if (name1.length === 0) {
                return name2;
                console.log("if else")
            } else return name1;
        }

        putMethod = {
            method: 'PUT', // Method itself
            headers: {
                'Content-type': 'application/json; charset=UTF-8' // Indicates the content
            },
            body: JSON.stringify(someData) // We send data in JSON format
        }

        url = `http://localhost:8080/admin/${idMain}`;


        fetch(url, putMethod)
            .then(response => response.json())
            .then(data => console.log(data)) // Manipulate the data retrieved back, if we want to do something with it
            .catch(err => console.log(err))
        MainRedirect();
    })
}
