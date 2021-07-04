



function MainRedirect() {
    console.log('MainRedirect');
    setTimeout(redirectPage, 500);
}
function redirectPage() {
    // console.log("redirectPage")
    // document.location.href = 'admin.html'
    document.location.href = 'http://localhost:8080/api/admin';
}