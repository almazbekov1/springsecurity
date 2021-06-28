
function getUserDelete(id, firstName, lastName, age, email) {
    let idMain, firstNameMain, lastNameMain, ageMain, emailMain;
    idMain = id;
    firstNameMain = firstName;
    lastNameMain = lastName;
    ageMain = age;
    emailMain = email;

    console.log("testDelete")
    let html = `      
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">х</button>
                    <h4 class="modal-title">Заголовок окна</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form role="form" class="form-horizontal" id="MainDeleteFinish">
                            <div class="form-group">
                                <label for="MainFirstNameDelete" class="control-label col-md-2">First Name</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="MainFirstNameDelete" placeholder=${firstNameMain}>
<!--                                                    <p class="help-block">Некая подсказка</p>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="MainLastNameDelete" class="control-label col-md-2">Last Name</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" id="MainLastNameDelete" placeholder=${lastNameMain}>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="MainAgeDelete" class="control-label col-md-2">Age</label>
                                <div class="col-md-6">
                                    <input type="number" class="form-control" id="MainAgeDelete" placeholder=${ageMain}>
                                    <!--                <p class="help-block">Некая подсказка</p>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="MainEmailDelete" class="control-label col-md-2">Email</label>
                                <div class="col-md-6">
                                    <input type="email" class="form-control" id="MainEmailDelete" placeholder=${emailMain}>
                                    <!--                <p class="help-block">Некая подсказка</p>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="MainPasswordDelete" class="control-label col-md-2">Password</label>
                                <div class="col-md-6">
                                    <input type="password" class="form-control" id="MainPasswordDelete" placeholder=password>
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
                                <button type="submit" class="btn btn-success"  >Delete</button>
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
    document.querySelector("#DeleteModal").insertAdjacentHTML("afterbegin",html);
    editUser = document.getElementById('MainDeleteFinish');

    editUser.addEventListener('submit',async function (event) {
        event.preventDefault()
        const deleteMethod = {
            method: 'DELETE', // Method itself
            headers: {
                'Content-type': 'application/json; charset=UTF-8' // Indicates the content
            },
        }

        url = `http://localhost:8080/admin/${idMain}`;
        fetch(url, deleteMethod)
            .catch(err => console.log(err)) // Do something with the error
        MainRedirect();
    })
}




