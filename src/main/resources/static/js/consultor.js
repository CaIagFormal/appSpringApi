function apiFaltandoUnico() {
    let data = $("#data").val();
    let endereco = $("#endereco").val();

    if (isNaN(Date.parse(data))) {
        alert("Data inválida...");
        return;
    }

    if (endereco.trim()=="") {
        alert("Endereço inválido...");
        return;
    }
    let div = $("#produtos");
    let nome = $("#endereco").val();

    $("#ips").children().each(function(index) {
        if (nome==$(this).val()) {
            nome = $(this).text();
            return false;
        }
    })

    apiFaltando(data,endereco,div,nome);
}

function apiFaltandoTodos() {
    $("#produtos").html("");
    let data = $("#data").val();

    if (isNaN(Date.parse(data))) {
        alert("Data inválida...");
        return;
    }

    $("#ips").children().each(
    function(index) {
    try {
        apiFaltandoCada(this,index,data);
    } catch( ex ) {
        console.log("Falha ao comunicar com "+$(this).text()+" ("+$(this).val()+")...")
    }

      });
}

function apiFaltandoCada(ip,index,data) {
        console.log("Buscando em "+$(ip).text()+" ("+$(ip).val()+")...");
        let endereco = $(ip).val();
        $("#produtos").append("<div id=\"prod_" + index + "\"></div>");
        let div = $(("#prod_"+index));

        let nome = $(ip).text();
        apiFaltando(data,endereco,div,nome);
}

function apiFaltando(data,endereco,div,nome) {
    $.ajax({
        data:{data:data,endereco:endereco},
        url:"/faltando",
        method:"POST",
        success: function(valores) {
            $(div).html(valores);
            $(div).prepend("<h4>"+nome+"</h4>");
        },
        error: function() {
            alert("Algo não deu certo...");
        }
        });
}

$("#api-consultor-unico").click(apiFaltandoUnico);
$("#api-consultor-todos").click(apiFaltandoTodos);