$(document).ready(function () {
    $.getJSON('/list', function (json) {
        let tr = [];
        for (let i = 0; i < json.length; i++) {
            tr.push('<tr>');
            tr.push('<td>' + json[i].date + '</td>');
            tr.push('<td>' + json[i].typeOfTransaction + '</td>');
            tr.push('<td>' + json[i].id + '</td>');
            tr.push('<td>' + json[i].id+ '</td>');
            tr.push('<td>' + json[i].sumOfTransaction + '</td>');
            tr.push('<td>' + json[i].id + '</td>');
            tr.push('<td>' + json[i].id + '</td>');
            tr.push('<td>' + json[i].id + '</td>');
            tr.push('<td><button type="button" class="btn-primary">UPDATE</button>&nbsp;&nbsp;</td>');
            tr.push('</tr>');
        }
        $("#tableUserList").append($(tr.join('')));
        console.log(json);
    });
});