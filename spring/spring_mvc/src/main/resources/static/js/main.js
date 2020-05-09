  // data response by server
	var listMovie = [{
		id:1,
		name:"Man of Steel",
		image:"http://henrycavill.org/images/Films/2013-Man-of-Steel/posters/3-Walmart-Superman-a.jpg",
		year:2019,
		actor:"Superman"
	},{
		id:2,
		name:"Minions Moon Cake",
		image:"https://charliederry.files.wordpress.com/2015/07/minions1.jpg?w=800",
		year:2019,
		actor:"Bill Scorlpe"
	},{
		id:3,
		name:"Asssin John Wicks",
		image:"https://timesofindia.indiatimes.com/thumb/msid-68721293,imgsize-172358,width-800,height-600,resizemode-4/68721293.jpg",
		year:2019,
		actor:"Back Craden"
	},{
		id:4,
		name:"Averange End Game",
		image:"https://is3-ssl.mzstatic.com/image/thumb/Video113/v4/6e/47/f6/6e47f680-ac54-21ff-a37a-3aab1a9970b0/DIS_AV_ENDGAME_FINAL_ENGLISH_US_WW_WW_ARTWORK_EN_2000x3000_1OWPBJ00000GQ6.lsr/268x0w.jpg",
		year:2019,
		actor:"Will Smith"
	}];


  //listMovie.forEach( (item) => console.log("item of list film",item) );
  
  
  $(document).ready(function(){

    $('#addFilm').dblclick(function(){
      toastr.success('Đã thêm thành công');
      $('#listFilm').append(`<div class="movie-card">
		<div class="movie-header"  style=" background: url(123);background-size: cover;">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"></i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Test Phim</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Date & Time</label>
					<span>14/8/2019 10:00:00</span>
				</div><!--date,time-->
				<div class="info-section">
					<label>Actor</label>
					<span>ABCD</span>
				</div><!--screen-->
				<div class="info-section">
					<label>Row</label>
					<span>D</span>
				</div><!--row-->
				<div class="info-section">
					<label>Seat</label>
					<span>05,06</span>
				</div><!--seat-->
			</div>
		</div>
  </div>`);
  
    });
      

    $.ajax({
      url: "https://jsonplaceholder.typicode.com/todos/1",
      success: function(result){
          //console.log(result);
          
      		listMovie.forEach((item) => {
            // "<div>" + 123 + "</div>"  ``
            //document.getElemnetById("listFilm") 
			  $('#listFilm').append(`<div class="movie-card">
		<div class="movie-header"  style=" background: url(${item.image});background-size: cover;">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"></i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">${item.name}</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Date & Time</label>
					<span>14/8/2019 10:00:00</span>
				</div><!--date,time-->
				<div class="info-section">
					<label>Actor</label>
					<span>${item.actor}</span>
				</div><!--screen-->
				<div class="info-section">
					<label>Row</label>
					<span>D</span>
				</div><!--row-->
				<div class="info-section">
					<label>Seat</label>
					<span>05,06</span>
				</div><!--seat-->
			</div>
		</div><!--movie-content-->
	</div><!--movie-card-->
	`);
			});
    	}});
	});
