var btnIngresar = document.getElementById("btnIngresar");

btnIngresar.addEventListener("click", function() {

    var usuario = document.getElementById("user").value;
    var contraseña = document.getElementById("password").value;

    axios.post("http://localhost:4567/logearUsuario", {

        usuario : usuario,
        contraseña : contraseña

    })
        .then(function(response) {

            if(response.data.redirect == 1) {

                alert("Bienvenido " + response.data.usuario);
                location.pathname("/PrincipalAlumno.html");

            } else {

                if(response.data.redirect == 2) {

                    alert("Bienvenido " + response.data.usuario);
                    location.pathname("/PrincipalProfesor.html");

                } else {

                    alert("No esta registrado :(");
                    location.reload();

                }

            }

        })

        .catch(function(error) {

            console.log(error);
            alert("Error al iniciar sesion :(")

        })

});