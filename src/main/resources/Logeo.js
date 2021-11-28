var btnIngresar = document.getElementById("btnIngresar");

btnIngresar.addEventListener("click", function() {

    var usuario = document.getElementById("user").value;
    var contraseña = document.getElementById("password").value;

    axios.post("/logearUsuario", {

        usuario : usuario,
        contraseña : contraseña

    })
        .then(function(response) {

            console.log(response.data);

        })

        .catch(function(error) {

            console.log(error);
            alert("Error al iniciar sesion :(")

        })

});