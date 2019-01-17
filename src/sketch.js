let y = [];
let x = [];
let fourierY ;
let fourierX ;
let time = 0;
let path = [];


function setup() {
  createCanvas(800, 600);
  for(let i =0 ; i< 500 ; i++){
    x[i] = 150 * noise(i/60 + 1000);
    y[i] = 150 * noise(i/60);
  }
  
  fourierY = dft(y);
  fourierX = dft(x);
  fourierX.sort((a,b) => b.amp - a.amp);
  fourierY.sort((a,b) => b.amp - a.amp);
}

function epiCycles(x,y, rotation,fourier){

   for (let i = 0; i < fourier.length; i++) {
    let prevx = x;
    let prevy = y;
    let freq = fourier[i].freq;
    let radius = fourier[i].amp;
    let phase = fourier[i].phase;
    x += radius * cos(freq * time + phase + rotation);
    y += radius * sin(freq * time + phase + rotation);

    stroke(255, 100);
    noFill();
    ellipse(prevx, prevy, radius * 2);
    stroke(255);
    line(prevx, prevy, x, y);
  }
  return createVector(x,y);
    
}


function draw() {
  background(0);

  let vx = epiCycles(width / 2 , 100, 0, fourierX);
  let vy = epiCycles(100 , height / 2, HALF_PI, fourierY);
  
  let v = createVector(vx.x , vy.y);
  path.unshift(v);
  
  line(vx.x,vx.y , v.x,v.y);
  line(vy.x,vy.y , v.x,v.y)
  
  beginShape();
  noFill();
  for (let i = 0; i < path.length; i++) {
    vertex(path[i].x, path[i].y);
  }
  endShape();

  const dt = TWO_PI / fourierY.length ;
  time += dt ;
  if (time > TWO_PI){
    time = 0; 
    path = [] ;
  }

}

