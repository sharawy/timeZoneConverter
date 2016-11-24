
angular.module('app', ['ui.bootstrap', 'ui.bootstrap.datetimepicker']);
angular.module('app')
    .service('dateService', ['$http', function ($http) {
            
        var urlBase = '/TimeZoneConverter/';

    var service = {
        listTimeZones: listTimeZones,
        convertTimeZone: convertTimeZone
    };
    return service;

    ////////////

    function listTimeZones() {
        /* */
        return $http.get(urlBase+"timeZones");
    };

    function convertTimeZone(timeZoneModel) {
        /* */
     return $http.get(urlBase+"convertTimeZone"+"?zoneId="+timeZoneModel.zoneId.label + 
           "&time=" +timeZoneModel.time);
    };
    }
]);
angular.module('app').controller('MyController', ['$scope','dateService','$filter',
    function($scope,dateService,$filter) {
     var that = this;
        $scope.model={
         zoneId:null,
         time:null
     };
     $scope.timeZones=[];
    // time picker
    $scope.picker2 = {
        date: null,
        timepickerOptions: {
            readonlyInput: false,
            showMeridian: false,
            dateFormat: 'yyyy-MM-dd HH:mm'
        }
    };
    
    $scope.openCalendar = function(e, picker) {
        that[picker].open = true;
    };
    dateService.listTimeZones().then(function (resposne){
        var zones = resposne.data.data;
       for (var i=0;i  < zones.length;i++){
            $scope.timeZones.push({"id":zones[i],"label":zones[i]});
       }
    });
     $scope.convert =  function () {
         if($scope.picker2.date == null ){
             alert("please provide time to convert.");
         return;
         }
         if($scope.model.zoneId == null){
             alert("please provide time zone to conver to.");
             return;
         }
      $scope.model.time= $filter('date')( $scope.picker2.date, 'yyyy-MM-dd HH:mm');
       
      dateService.convertTimeZone( $scope.model).then(function (response){
          $scope.result=response.data.data;
      });
      
    };

}]);