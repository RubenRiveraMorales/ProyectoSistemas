var btnIngresar = document.getElementById("btnIngresar");

btnIngresar.addEventListener("click", function() {

    var usuario = document.getElementById("user").value;
    var contraseña = document.getElementById("password").value;

    axios.post("http://localhost:4567/logearUsuario", {

        usuario : usuario,
        contraseña : contraseña

    })
        .then(function(response) {

            if(response.data == 1) {

                alert("Bienvenido " + usuario);
                //location.pathname("")

            } else {

                alert("Usuario o contraseña incorrectas :(");
                location.reload();

            }

        })

        .catch(function(error) {

            console.log(error);
            alert("Error al iniciar sesion :(")

        })

});