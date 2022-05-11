import { GradePipe } from './grade.pipe';

let pipe:GradePipe;
beforeEach(() => {
  pipe = new GradePipe();
});

describe('GradePipe', () => {


  it('create an instance', () => {
    const pipe = new GradePipe();
    expect(pipe).toBeTruthy();
  });

  it('should return "Good" when input is 5', () => {
    let result = pipe.transform(5);
    expect(result).toBe("Good");

  });

  it('should return "average" when input is 6', () => {
    let result = pipe.transform(6);
    expect(result).toBe("average");

  });


  it('should return "veryGood" when input is 7', () => {
    let result = pipe.transform(7);
    expect(result).toBe("verygood");

  });


  it('should return "excellent" when input is 8', () => {
    let result = pipe.transform(8);
    expect(result).toBe("excellent");

  });

  it('should return "Poor" when input is 9', () => {
    let result = pipe.transform(9);
    expect(result).toBe("Poor");

  });


  it('should return "empty string" when input is invalid grade', () => {
    let result = pipe.transform(97);
    expect(result).toBe("");

  });
});
