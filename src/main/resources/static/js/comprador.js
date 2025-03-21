var qtdtotal = 0;
var qtdfiliais = [];
var qtddatas = [];
var filiais = [];
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

    if (filiais.includes(nome)) {
        alert("Filial já adicionada")
        return;
    }
    filiais.push(nome);
    qtddatas.push(currentDateStr);

    let div = $(".template-filial").clone();
    $("#filiais").append(div);
    $(div).removeClass("template-filial d-none");
    $(div).find("h4").text(nome);

    let qtd = $(div).find(".qtd");
    let index = qtdfiliais.length;
    $(qtd).attr('id', 'qtd_'+index);
    $(div).find("label").attr('for', 'qtd_'+index);
    qtdfiliais.push(1);
    $(qtd).change(function() {filialQtdChange(qtd,index)});
    $("#qtd-total").change(function() {filialQtdChange(qtd,index)});

    $("#qtd-total").attr("min",qtdfiliais.length);

    let data = $(div).find(".data");
    $(data).change(function() {qtddatas[index] = $(data).val()});

    let remover = $(div).find(".remover")[0];

    $(".remover").click(function(event) {
        if (event.target == remover) {
            qtdfiliais.splice(index,1);
            filiais.splice(index,1);
            qtddatas.splice(index,1);

            $(div).remove();
            return;
        }

        index = filiais.indexOf(nome);
    })

    chgTotal();
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

function enviar() {
    let fil_total = qtdfiliais.reduce((partialSum, a) => partialSum + a, 0);

    if (qtdtotal != fil_total) {
        alert("Não foi distribuido o produto apropriadamente!");
        return;
    }

    let produto = $("#produto").val();

    if (produto.trim()=="") {
        alert("Produto inválido!");
        return;
    }

    let fornecedor = $("#fornecedor").val();

    if (fornecedor.trim()=="") {
        alert("Fornecedor inválido!");
        return;
    }

    let json = [];
    let endereco;
    for (let i = 0; i < filiais.length; i++) {
        $("#ips").children().each(function(index) {
            if (filiais[i]==$(this).text()) {
                endereco = $(this).val();
                return false;
            }
        })
        let filial = {filial:endereco,produto:produto,quantidade:qtdfiliais[i],fornecedor:fornecedor,data:qtddatas[i]};
        json.push(filial);
    }

    console.log(json);

    $.ajax({
            data:{dados:JSON.stringify(json)},
            url:"/enviarproduto",
            method:"POST",
            success: function(mensagem) {
                alert(mensagem);
            },
            error: function() {
                alert("Algo não deu certo...");
            }
            });
}

$("#add-filial").click(addFilial);

$("#qtd-total").change(chgTotal);

$("#enviar").click(enviar)