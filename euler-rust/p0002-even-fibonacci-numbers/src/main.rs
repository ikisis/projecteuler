fn main() {
    let mut a = 2;
    let mut b = 3;
    let mut sum = 0;

    while a < 4000000 {
        sum += a;
        let c = a + b;
        a = b + c;
        b = c + a;
    }

    println!("fib sum : {sum}");
}
