var currentDate = new Date();

var currentDateStr = currentDate.toISOString().split('T')[0]

$(".data-atual").val(currentDateStr);

$(".data-max-atual").attr({"max":currentDateStr});