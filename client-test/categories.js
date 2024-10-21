$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/categories/",
        headers: {
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MjE5MDA1NjIsImV4cCI6MTcyMTkwNDE2MiwidXNlcklkIjo2LCJlbWFpbCI6ImJpamF5dGhhcGFAZ21haWwuY29tIiwiZmlyc3ROYW1lIjoiYmlqYXkiLCJsYXN0TmFtZSI6InRoYXBhIn0.TPCZJzPQJDtk-jIh6i4LRukwv6xLf-rjbaqED-Zg9II',
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
