$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/categories/",
        headers: {
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTIzNDYzMzYsImV4cCI6MTYxMjM1MzUzNiwidXNlcklkIjoxNSwiZW1haWwiOiJiaWpheUBlbWFpbC5jb20iLCJmaXJzdE5hbWUiOiJCaWpheSIsImxhc3ROYW1lIjoiVGhhcGEifQ.NiyUzVeXEcm4Myrfdu82L-7WZJXEBjdLIYnARinp6VE',
        },
        dataType: 'json',
    }).then(function (data) {
        $('.expCategoryId').append(data.categoryId);
        $('.expUserId').append(data.userId);
        $('.expTitle').append(data.title);
        $('.expDescription').append(data.description);
        $('.expTotalExpense').append(data.totalExpense);
    });
});
