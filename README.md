# Vehicle Parking System
This is a sample parking system which handles vehicle entry and exit flows

#Users

User -> User Name : user , Password : password
Admin -> User Name : admin , Password : admin

### Parking System API calls

1. **Create Parking Slot** : This API creates parking slot with the given name<br/>**Method Type** : POST<br/>**Url** : http://localhost:8080/parking/slot<br/>**Header** : Content-Type : application/json<br/>**Body** : 
```json

ALLOW FOR ADMIN ROLE

{
  "name"   : "slot name"
  "isFree" : true
}
```
**Result** : 
```json
{
"msg": "Successfully created parking slot",
"dateTime": "2019-04-01T12:04:49.334+0000"
}
```

2. **Get Parking slots** : Returns the json representation of the parking slots.<br/>**Method Type** : GET<br/>**Url** : http://localhost:8080/parking/slot<br/>**Result** : 
```json


```
