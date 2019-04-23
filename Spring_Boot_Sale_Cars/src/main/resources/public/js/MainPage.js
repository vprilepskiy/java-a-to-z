var base64 = "data:image/png;base64, ";

/**
 * Показать все детали. Параметры взять с DOM.
 */
function viewItems() {
    var today = document.getElementById("today").checked;
    var with_photo = document.getElementById("witch_photo").checked;
    var index_mark = document.getElementById("select_mark_filter").options.selectedIndex;
    var mark_id = document.getElementById("select_mark_filter").options[index_mark].value;
    var active = document.getElementById("active").checked;
    var only_my = document.getElementById("only_my_checkbox").checked;

    viewAllItems(today, with_photo, mark_id, active, only_my);
}

/**
 * Показать все детали с учетом параметров.
 */
function viewAllItems(today, with_photo, mark_id, active, only_my) {
    $(
        $.ajax('../api/Items.skip', {
            method: 'get',
            data: ({today: today, withPhoto: with_photo, markId: mark_id, active: active, onlyMy: only_my}),
            complete: function (data) {
                console.log('Items', data.responseText);
                if (data.responseText != '') {

                    var items = JSON.parse(data.responseText);

                    var result = "<tr>" +
                        "<th>id</th>" +
                        "<th>Mark</th>" +
                        "<th>Model</th>" +
                        "<th>Body type</th>" +
                        "<th>Year</th>" +
                        "<th>Price</th>" +
                        "<th>Created</th>" +
                        "<th>Active</th>" +
                        "<th>Photo</th>" +
                        "<th></th>" +
                        "</tr>";

                    for (var i = 0; i != items.length; ++i) {

                        var check = items[i].active ? ' checked ' : ' ';

                        var form_add_photo = "<form method='POST' enctype='multipart/form-data' class='fileUploadForm'>" +
                            "<input type='file' name='files'>" +
                            "<input type='number' value='" + items[i].id + "' name='itemId' about='attributes for upload' hidden>" +
                            "<input type='button' value='Загрузить' onclick='file_ajax_submit(this);'/>" +
                        "</form>";

                        var photo = "<img src='" + base64 + items[i].photo + "' alt='none', height='120'>";

                        result += "<tr>" +
                            "<td>" + items[i].id + "</td>" +
                            "<td>" + items[i].mark.description + "</td>" +
                            "<td>" + items[i].model.description + "</td>" +
                            "<td>" + items[i].bodyType.description + "</td>" +
                            "<td>" + items[i].year + "</td>" +
                            "<td>" + items[i].price + "</td>" +
                            "<td>" + DateFormat.format.date(new Date(items[i].created), 'dd/MM/yyyy HH:mm"ss') + "</td>" +
                            "<td>" +
                            "<input type='checkbox' value='" + items[i].id + "'" + check + "onchange='setState(this.value, this.checked);'" + "/>" +
                            "</td>" +
                            "<td>" + photo + "</td>" +
                            "<td>" + form_add_photo + "</td>" +
                            "</tr>";
                    }

                    var table = document.getElementById("View_all_items");
                    table.innerHTML = result;
                } else {
                    console.log("Items: responseText is empty");
                }
            }
        })
    );
}
;

/**
 * Типы кузовов.
 */
function viewBodyTypes() {
    $(
        $.ajax('../api/BodyTypes.skip', {
            method: 'get',
            complete: function (data) {

                console.log(data.responseText);

                if (data.responseText != '') {

                    var bodyTypes = JSON.parse(data.responseText);

                    for (var i = 0; i != bodyTypes.length; ++i) {
                        var option = document.createElement("option");
                        option.setAttribute("value", bodyTypes[i].id);
                        option.innerHTML = bodyTypes[i].description;
                        document.getElementById("select_body_type").appendChild(option);
                    }
                } else {
                    console.log("BodyTypes: responseText is empty");
                }
            }
        })
    );
}
;


/**
 * Марки и модели.
 * Загружается один раз.
 */
var MARKS;

/**
 * Получить марки и модели. Передать в глобальную переменную.
 */
function getMarks() {
    $.ajax('../api/Marks.skip', {
        method: 'get',
        complete: function (data) {

            console.log(data.responseText);

            if (data.responseText != '') {
                var marks = JSON.parse(data.responseText);
                MARKS = marks;
                viewMarks(MARKS, 'select_mark');
                viewMarks(MARKS, 'select_mark_filter');
                viewModels(MARKS, MARKS[0].id);
            } else {
                console.log("Marks: responseText is empty");
            }
        }
    });
}
;

/**
 * Отобразить возможные марки.
 * @param marks - марки.
 */
function viewMarks(marks, elementId) {
    if (marks != '') {

        for (var i = 0; i != marks.length; ++i) {
            var option = document.createElement("option");
            option.setAttribute("value", marks[i].id);
            option.innerHTML = marks[i].description;
            document.getElementById(elementId).appendChild(option);
        }
    } else {
        console.log("Marks: JSON Text is empty");
    }
}
;

/**
 * Отобразить возможные модели по id марки.
 * @param marks - марки.
 * @param id - номер марки.
 */
function viewModels(marks, id) {
    if (marks != '') {

        console.log("viewModels marks:" + marks.toString());

        for (var i = 0; i != marks.length; ++i) {
            if (marks[i].id == id) {

                // удалить варианты выбора
                var select_model = document.getElementById("select_model");
                while (select_model.firstChild) {
                    select_model.removeChild(select_model.firstChild);
                }

                console.log("viewModels marks[i].id:" + marks[i].id);

                for (var j = 0; j != marks[i].models.length; ++j) {

                    console.log("viewModels marks[i].models:" + marks[i].models);

                    // добавить варианты выбора
                    var option = document.createElement("option");
                    option.setAttribute("value", marks[i].models[j].id);
                    option.innerHTML = marks[i].models[j].description;
                    document.getElementById("select_model").appendChild(option);
                }
            }
        }

    } else {
        console.log("Marks: JSON Text is empty");
    }
}
;

/**
 * Добавить новое объявление.
 */
function addItem() {
    var index_mark = document.getElementById("select_mark").options.selectedIndex;
    var mark_id = document.getElementById("select_mark").options[index_mark].value;

    var index_model = document.getElementById("select_model").options.selectedIndex;
    var model_id = document.getElementById("select_model").options[index_model].value;

    var index_body_type = document.getElementById("select_body_type").options.selectedIndex;
    var body_type_id = document.getElementById("select_body_type").options[index_body_type].value;

    var year = document.getElementById("year").value;

    var price = document.getElementById("price").value;

    $.ajax('../api/Item', {
        method: 'post',
        data: ({markId: mark_id, modelId: model_id, bodyTypeId: body_type_id, year: year, price: price}),
        complete: function () {
            viewItems();
        }
    });
};

/**
 * Изменить состояние объявления.
 * @param item_id - номер объявления.
 * @param state - состояние.
 */
function setState(item_id, state) {
    $.ajax('../api/SetStateItem', {
        method: 'post',
        data: ({itemId: item_id, state: state}),
        complete: function (data) {
            viewItems();
        }
    });
};

/**
 * Загрузить картинку.
 * @param element
 */
function file_ajax_submit(element) {

    var data = new FormData(element.parentElement);
    data.append("CustomField", "This is some extra data, testing");

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/api/io/upload",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
            viewItems();
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
};

/**
 * Проверит статус и установит видимость блоков.
 */
function viewSessionStatus() {
    $(
        $.ajax('../auth/user', {
            method: 'get',
            complete: function (data) {

                console.log(data.responseText);

                if (data.responseText != '') {

                    var login = data.responseText;

                    // отобразить логин зарегестрировавшегося пользователя
                    var htmlMessage = document.getElementById("message");
                    htmlMessage.innerHTML = "User name: " + login;

                    // показать блок
                    $("#LogOut_form").show("slow");

                    // скрыть блок
                    $("#LogIn_form").hide("slow");

                    // показать блок
                    $("#add_item_form").show("slow");

                    // показать блок
                    $("#only_my").show("slow");

                    // скрыть блок
                    $("#Reg_form").hide("slow");

                } else {
                    // скрыть блок
                    $("#LogOut_form").hide("slow");

                    // показать блок
                    $("#LogIn_form").show("slow");

                    // скрыть блок
                    $("#add_item_form").hide();

                    // скрыть блок
                    $("#only_my").hide("slow");

                    // показать блок
                    $("#Reg_form").show("slow");
                }
            }
        })
    );
}
;

/**
 * Вернет false если один из аргументов будет пустым.
 * @param args - аргументы.
 */
function validate(args) {
    var result = true;

    for (var i = 0; i < args.length; i++) {
        if (args[i] == "") {
            result = false;
            break;
        }
    }
    return result;
}
;

/**
 * Проверит пользователя в БД по Логину/Паролю.
 * Вернет статус 'Ok' или 'Error'.
 */
function signIn() {
    var login = document.getElementsByName("login").item(0).value;
    var password = document.getElementsByName("password").item(0).value;
    var args = [login, password];
    if (validate(args)) {
        $.ajax('../auth/login', {
            method: 'post',
            data: ({login: login, password: password}),
            complete: function (data) {
                var response = data.responseText;
                var htmlMessage = document.getElementById("message");

                if (response === 'true') {
                    viewSessionStatus();
                } else {
                    htmlMessage.innerHTML = 'Введите правильный логин/пароль';
                }

                viewAllItems(false, false, 0, false, false);
            }
        })
    } else {
        alert("Not filled in login/password!");
    }
}
;

/**
 * Завершит сессию.
 */
function signOut() {
    $(
        $.ajax('../logout', {
            method: 'GET',
            complete: function () {
                location.reload();
            }
        })
    );
}
;

// init
viewAllItems(false, false, 0, false, false);
viewBodyTypes();
getMarks();
viewSessionStatus();
