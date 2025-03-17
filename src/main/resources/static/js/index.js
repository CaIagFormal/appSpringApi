$("#data").val(new Date().toISOString().split('T')[0]);

function getApi() {
    let data = $("#data").val();
    let endereco = $("#endereco").val();

    $.ajax({
    data:{data:data,endereco:endereco},
    url:"/API",
    method:"POST",
    success: function(valores) {
        $("#produtos").html(valores);

    }
    });
}

$("#enviar").click(getApi);