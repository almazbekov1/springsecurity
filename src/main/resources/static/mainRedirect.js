



function MainRedirect() {
    console.log('MainRedirect');
    setTimeout(redirectPage, 100);
}
function redirectPage() {
    console.log("redirectPage")
    // document.location.href = 'admin.html'
    document.location.href = 'http://localhost:8080/';

}