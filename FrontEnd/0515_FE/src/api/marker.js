// //위도 경도 부드럽게 이동
// function panTo(lat, lng) {
//     var moveLatLon = new window.kakao.maps.LatLng(lat, lng); // 이동 위치 생성
//     map.panTo(moveLatLon);
//   }

//   //마커 관련
// function setMarker(lat, lng) {
//     // 마커가 표시될 위치입니다 
//     var markerPosition  = new window.kakao.maps.LatLng(lat, lng); 
//     // 마커를 생성합니다
//     var marker = new window.kakao.maps.Marker({
//       position: markerPosition,
//       text: '텍스트입니다'
//     });
//     marker.setMap(map); // 마커가 지도 위에 표시
//     //marker.setMap(null); : 마커 제거
//   }

//   export { panTo, setMarker }; //외부로 export