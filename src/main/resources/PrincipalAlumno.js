document.body.onload = function() {

    //Hacerlo en un bucle, for o while
    //for(let i=0; i<15; i++) {

        let divListaEncuesta = document.getElementById("listadoEncuestas");
        let divEncuesta = document.createElement("div");
        let labelNomEncuesta = document.createElement("label");
        let labelProfesor = document.createElement("label");
        let labelCalificacion = document.createElement("label");
        let btnContestar = document.createElement("button");

        divEncuesta.style.border = "thin solid #00CC66";
        divEncuesta.style.marginTop = "30px";
        divEncuesta.style.marginBottom = "30px";
        divEncuesta.style.padding = "30px";
        divEncuesta.style.display = "flex";
        divEncuesta.style.justifyContent = "center";
        divEncuesta.style.alignItems = "center";

        btnContestar.className = "btn btn-outline-secondary";
        btnContestar.innerHTML = "Contestar encuesta";

        let arregloJS = obtenerEncuesta(1);

        divEncuesta.appendChild(labelNomEncuesta);
        divEncuesta.appendChild(labelProfesor);
        divEncuesta.appendChild(labelCalificacion);
        divEncuesta.appendChild(btnContestar);

        divListaEncuesta.appendChild(divEncuesta);

    //}

}

function obtenerEncuesta(noEncuesta) {

    axios.post("http://localhost:4567/obtenerEncuesta", {

        noEncuesta : noEncuesta

    })

        .then(function(respose) {

            return respose.data;

        })

        .catch(function(error) {

            console.log(error);
            alert("No se obtuvo encuesta");

        })

};