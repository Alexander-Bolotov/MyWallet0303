$(document).ready(function () {
    $.getJSON('/list', function (json) {

        let tr = [];
        for (let i = 0; i < json.length; i++) {
            let date_in = new Date(json[i].date);
            tr.push('<tr>');
            tr.push('<td>' + date_in.toLocaleDateString('ru-RU') + '</td>');
            tr.push('<td>' + json[i].typeOfTransaction.typeOfTransaction + '</td>');
            tr.push('<td>' + json[i].income_Wallet.wallet + '</td>');
            tr.push('<td>' + json[i].out_Wallet.wallet + '</td>');
            tr.push('<td>' + json[i].sumOfTransaction + '</td>');
            tr.push('<td>' + json[i].user.name + '</td>');
            tr.push('<td>' + json[i].comment + '</td>');
            tr.push('<td>' + json[i].category.category + '</td>');
            tr.push('<td id =' + "edit" + json[i].id + '><button type="button" class="btn-primary" id=>UPDATE</button>&nbsp;&nbsp;</td>');
            tr.push('</tr>');
        }
        $("#tableUserList").append($(tr.join('')));
        console.log(json);
    });

    $(document).delegate('button[id^=addButton]', 'click', function () {

        $("#myModalBox").modal('show');
        let today = new Date();

        document.getElementById('data').valueAsDate = today;

    });

    $(function() {
        $('#some-select').on('change', function() {
            // alert( this.value);
            let label = this.value;
            if (label == 1) {
                document.getElementById("incomeWallet").style.display = 'block';
                document.getElementById("lab1").style.display = 'block';
                document.getElementById("lab2").style.display = 'none';
                document.getElementById("outWallet").style.display = 'none';
            } else if (label == 2) {
                document.getElementById("lab2").style.display = 'block';
                document.getElementById("outWallet").style.display = 'block';
                document.getElementById("incomeWallet").style.display = 'none';
                document.getElementById("lab1").style.display = 'none';
            } else if (label == 3) {
                document.getElementById("incomeWallet").style.display = 'block';
                document.getElementById("lab1").style.display = 'block';
                document.getElementById("lab2").style.display = 'block';
                document.getElementById("outWallet").style.display = 'block';}
            else {
                document.getElementById("incomeWallet").style.display = 'none';
                document.getElementById("lab1").style.display = 'none';
                document.getElementById("lab2").style.display = 'none';
                document.getElementById("outWallet").style.display = 'none';
               }

        })

    });
});