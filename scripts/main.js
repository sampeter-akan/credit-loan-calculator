function calculateFutureValue(monthlyPayment, years, interestRate) {
    const months = years * 12;
    const monthlyRate = interestRate / 100 / 12;
    let futureValue = 0;

    for (let i = 0; i < months; i++) {
        futureValue = (futureValue + monthlyPayment) * (1 + monthlyRate);
    }

    return futureValue.toFixed(2);
}

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('fv-form');
    const resultDisplay = document.getElementById('result');

    form.addEventListener('submit', (event) => {
        event.preventDefault();

        const years = parseFloat(document.getElementById('years').value);
        const monthlyPayment = parseFloat(document.getElementById('monthly-payment').value);
        const interestRate = parseFloat(document.getElementById('interest-rate').value);

        if (!isNaN(years) && !isNaN(monthlyPayment) && !isNaN(interestRate)) {
            const futureValue = calculateFutureValue(monthlyPayment, years, interestRate);
            resultDisplay.textContent = `Future Value: $${futureValue}`;
        } else {
            resultDisplay.textContent = 'Please enter valid numbers.';
        }
    });
});