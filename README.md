# Vehicle Parking System
This is a sample parking system which handles vehicle entry and exit flows

#Users </br>

User -> User Name : user , Password : password </br>
Admin -> User Name : admin , Password : admin

### Parking System API calls

1. **Create Parking Slot** : This API creates parking slot with the given name<br/>**Method Type** : POST<br/>**Url** : http://localhost:8080/parking/slot<br/>**Header** : Content-Type : application/json<br/>
ALLOW FOR ADMIN ROLE
**Body** : 
```json

{
  "name"   : "slot name"
  "isFree" : true
}
```
**Result** : 
```json
{
"msg": "Successfully created parking slot",
"dateTime": "2022-11-11T04:54:22.258+0000"
}
```

2. **Get Parking slots** : Returns the json representation of the parking slots.<br/>**Method Type** : GET<br/>**Url** : http://localhost:8080/parking/slot<br/>**Result** : 
```json

{
  "id"     : 
  "name"   : "slot name"
  "isFree" : true
}
```

3. **Create Vehicle Park ** : Enters the vehicle information in the system.<br/>**Method Type** : POST<br/>**Url** : http://localhost:8080/vehicle/park-in-slot<br/>**Header** : Content-Type : application/json<br/>**Body** : 
```json
{
  "number" : "ABB 8800",
  "type" : 0
  "slotId" : 1
}
```
**Result** : 
```json
{
"msg": "Vehicle parking entry created",
"dateTime": "2022-11-11T04:54:22.258+0000"
}
```

4. **Create Vehicle Exit ** : Enters the vehicle exit time and free's the occupied slot and makes entry in ParkingEntry table<br/>**Method Type** : POST<br/>**Url** : http://localhost:8080/vehicle/park-out-slot<br/>**Header** : Content-Type : application/json<br/>**Body** : 
```json
{
  "id" : 52
}
```
**Result** : 
```json
{
"msg": "Vehicle exit from parking slot",
"dateTime": "2022-11-11T04:54:22.258+0000"
}
```

5. **Get Parking Entries** : Returns all the entries in the system.<br/>**Method Type** : GET<br/>**Url** : http://localhost:8080/parking/entries<br/>**Result** : 

```json
{

  "id" : 1,
  "slotName" : "slot name",
  "vehicleNumber" : "ABB 8800",
  "fare" : 50,
  "inTime" : "2022-11-11T04:54:22.258+0000",
  "outTime" : "2022-11-11T04:54:22.258+0000"

}

```
