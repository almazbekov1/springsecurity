
function fetchData() {
    fetch("http://localhost:8080/admin")
        .then(response =>{
            if (!response.ok){
                throw Error("error");
            }
            // console.log(response.json());
            return response.json();
        })
        .then(data => {
            // console.log(data);
            let html =  '<div class="container">\n' +
                '           <div class="table-responsive table-">\n' +
                '              <table class="table table-striped1 table-hover1 table-bordered1 table-condensed">\n' +
                '                <thead>\n' +
                '                  <tr class="active">\n' +
                '                     <th>id</th>\n' +
                '                     <th>firstName</th>\n' +
                '                     <th>lastName</th>\n' +
                '                     <th>age</th>\n' +
                '                     <th>email</th>\n' +
                '                     <th>role</th>\n' +
                '                     <th >Edit</th>\n' +
                '                     <th>Delete</th>\n' +
                '                  </tr>\n' +
                '                </thead>\n' +
                '                <tbody>';
            html= html + data
                .map(user => {
                    return `
                    <tr>
                       <td>${user.id}</td>
                       <td>${user.firstName}</td>
                       <td>${user.lastName}</td>
                       <td>${user.age}</td>
                       <td>${user.email}</td>
                       <td>Admin</td>
                       <td>
                           <button id="MainEdit" value="value"
                           onclick="getUserEdit(${user.id},'${user.firstName}','${user.lastName}',${user.age},'${user.email}')"
                                    class="btn btn-info" data-toggle="modal" data-target="#myModalEdit">Edit</button>
                       </td>
                       <td>
                           <button id="MainDelete" value="value"
                           onclick="getUserDelete(${user.id},'${user.firstName}','${user.lastName}',${user.age},'${user.email}')"
                                    class="btn btn-warning" data-toggle="modal" data-target="#myModalDelete">Delete</button>
                       </td>
                    </tr>
                    `;
                })
                .join("");
            // html = html;
            // console.log(html);
            document.querySelector("#mainTable").insertAdjacentHTML("afterbegin",html);
        })
        .catch(err => {
            console.log(err+" error you ");
        })
}
fetchData();
// <tr>
// <td>${user.id}</td>
// <td>${user.firstName}</td>
// <td>${user.lastName}</td>
// <td>${user.age}</td>
// <td>${user.email}</td>
// <td>${user.password}</td>
// </tr>