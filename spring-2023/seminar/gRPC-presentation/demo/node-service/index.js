function generateData() { 
  return ({
    time: Date.now(),
    value: Math.random() * 100,
    available: Math.random() < 0.5
  })
}
