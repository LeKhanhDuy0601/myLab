const host = "https://duylkpc0190-lab-default-rtdb.firebaseio.com";
const app = angular.module("app", []);
app.controller("ctrl", function ($scope, $http) {
    $scope.form = {};
    $scope.items = {};


    $scope.reset = function () {
        $scope.form = { gender: true, country: 'VN' };
        console.log("xoá trắng")
        $scope.key = null;
    }
    $scope.load_form = function () {
        var url = `${host}/student.json`;
        $http.get(url).then(req => {
            $scope.items = req.data;
            console.log("Thành Công: ", req)
        }).catch(err => {
            console.log("Thất Bại: ", err)
        })
    }
    $scope.edit = function (key) {
        var url = `${host}/student/${key}.json`;
        $http.get(url).then(req => {
            $scope.form = req.data;
            $scope.key = key;
            console.log("thành công: ", req)
        }).catch(err => {
            console.error("thất bại: ", err)
        })
    }
    $scope.update = function () {
        var item = angular.copy($scope.form);
        var url = `${host}/student/${$scope.key}.json`;
        $http.put(url, item).then(req => {
            $scope.items[$scope.key] = req.data;
            console.log("Cập Nhật Thành Công: ", req);
            alert("Cập Nhật Thành Công")
        }).catch(erro => {
            console.error("Lổi Cập Nhập: ", erro);
        })
    }
    $scope.delete = function (key) {
        var url = `${host}/student/${key}.json`;
        $http.delete(url).then(req => {
            delete $scope.items[key];
            $scope.reset();
            alert("Xoá Thành Công")
        }).catch(erro => {
            console.error("Xoá Thất Bại: ", erro)
        })
    }

    $scope.create = function(){
        var item = angular.copy($scope.form);
        var url = `${host}/student.json`;
        $http.post(url,item).then(req => {
            $scope.key = req.data.name;
            $scope.items[$scope.key] = item;
            $scope.reset();
            console.log("Thêm Thành Công: ", req)
            alert("Thêm Thành Công")
        }).catch(erro => {
            console.error("Thêm Thất Bại: ",erro);
        })
    }
    //
    $scope.load_form();
    $scope.reset();
})