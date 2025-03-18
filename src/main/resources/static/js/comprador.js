var qtdtotal = 0;
var qtdfiliais = [];
function chgTotal() {
    qtdtotal = parseInt($("#qtd-total").val());
    if (qtdtotal<qtdfiliais.length) {
        qtdtotal=qtdfiliais.length;
        $("#qtd-total").val(qtdfiliais.length);
    }
}

function addFilial() {
    let nome = "";

    $("#ips").children().each(function(index) {
        if ($("#endereco").val()==$(this).val()) {
            nome = $(this).text();
            return false;
        }
    })
    if (nome=="") {
        alert("Filial desconhecida...");
        return;
    }

    let div = $(".template-filial").clone();
    $("#filiais").append(div);
    $(div).removeClass("template-filial d-none");
    $(div).find("h4").text(nome);

    let qtd = $(div).find("input");
    let index = qtdfiliais.length;
    $(qtd).attr('id', 'qtd_'+index);
    $(div).find("label").attr('for', 'qtd_'+index);
    qtdfiliais.push(0);
    $(qtd).change(function() {filialQtdChange(qtd,index)});
    $("#qtd-total").change(function() {filialQtdChange(qtd,index)});

    $("#qtd-total").attr("min",qtdfiliais.length);
}

function filialQtdChange(qtd,index) {
    qtdfiliais[index] = parseInt($(qtd).val());

    // Compensar caso seja menor
    if  (qtdfiliais[index]<1) {
        qtdfiliais[index]=1;
    }
    let fil_total = qtdfiliais.reduce((partialSum, a) => partialSum + a, 0);

    if (fil_total<=qtdtotal) {
        $(qtd).val(qtdfiliais[index]);
        return;
    }

    // Compensar caso seja demais
    if (fil_total-qtdtotal<qtdfiliais[index]) {
        qtdfiliais[index] -= fil_total-qtdtotal;
    } else {
        qtdfiliais[index] = 1; // espere pelo melhor... D:
    }

    $(qtd).val(qtdfiliais[index]);
}

$("#add-filial").click(addFilial);

$("#qtd-total").change(chgTotal);