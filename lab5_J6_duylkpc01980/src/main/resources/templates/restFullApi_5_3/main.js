let host = "http://localhost:8080/rest";
const app = angular.module("app", []);
app.controller("ctrl", function ($scope, $http) {
    $scope.form = {};
    $scope.items = [];


    $scope.reset = function () {
        $scope.form = { gender: true, country: 'VN' };
        console.log("xoá trắng")
        $scope.key = null;
    }
    $scope.load_form = function () {
        var url = `${host}/students`;
        $http.get(url).then(req => {
            $scope.items = req.data;
            console.log("Thành Công: ", req)
        }).catch(err => {
            console.log("Thất Bại: ", err)
        })
    }
    $scope.edit = function (email) {
        var url = `${host}/students/${email}`;
        $http.get(url).then(req => {
            $scope.form = req.data;
            console.log("thành công: ", req)
        }).catch(err => {
            console.error("thất bại: ", err)
        })
    }
    $scope.update = function () {
        var item = angular.copy($scope.form);
        var url = `${host}/students/${$scope.form.email}`;
        $http.put(url, item).then(req => {
            var index = $scope.items.findIndex(item => item.email == $scope.form.email);
            $scope.items[index] = req.data;
            console.log("Cập Nhật Thành Công: ", req);
            alert("Cập Nhật Thành Công")
        }).catch(erro => {
            console.error("Lổi Cập Nhập: ", erro);
        })
    }
    $scope.delete = function (email) {
        var url = `${host}/students/${email}`;
        $http.delete(url).then(req => {
            var index = $scope.items.findIndex(item => item.email == email);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xoá Thành Công")
        }).catch(erro => {
            console.error("Xoá Thất Bại: ", erro)
        })
    }

    $scope.create = function () {
        var item = angular.copy($scope.form);
        var url = `${host}/students`;
        $http.post(url, item).then(req => {
            $scope.items.push(item);
            $scope.reset();
            $scope.load_form();
            console.log("Thêm Thành Công: ", req)
            alert("Thêm Thành Công")
        }).catch(erro => {
            console.error("Thêm Thất Bại: ", erro);
        })
    }
    //
    $scope.load_form();
    $scope.reset();
})