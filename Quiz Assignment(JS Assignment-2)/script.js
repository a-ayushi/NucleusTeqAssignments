const startBtn = document.getElementById("btn-start");
const restartBtn = document.getElementById("restart-btn");
const startScreen = document.getElementById("start-screen");
const quizContainer = document.getElementById("quiz-container");
const endScreen = document.getElementById("end-screen");
const questionEl = document.getElementById("question");
const optionsEl = document.getElementById("options");
const timerEl = document.getElementById("timer");
const remainedTime = document.getElementById("time");
const feedback = document.getElementById("feedback");
const currentScore = document.getElementById("livescore");
const score = document.getElementById("score");

//starting conditions
let questions = [];
let currentQuestionIndex = 0;
let scores = 0;
let timeLeft = 15;
let timer;

const init = function () {
  startScreen.classList.remove("hidden");
  endScreen.classList.add("hidden");
};
init();

//fetching the data from API
async function fetchData() {
  const category = document.getElementById("category").value;
  const difficulty = document.getElementById("difficulty").value;

  const response = await fetch(
    `https://opentdb.com/api.php?amount=15&category=${category}&difficulty=${difficulty}&type=multiple`
  );

  const data = await response.json();
  questions = data.results;

  startQuiz();
}

// startquiz function
function startQuiz() {
  startScreen.classList.add("hidden");
  quizContainer.classList.remove("hidden");
  currentScore.classList.remove("hidden");
  remainedTime.classList.remove("hidden");
  currentQuestionIndex = 0;
  scores = 0;
  moveToNextQuestion();
}

function moveToNextQuestion() {
  if (currentQuestionIndex >= questions.length) {
    endQuiz();
    return;
  }

  document.getElementById("question-number").textContent = `Question ${
    currentQuestionIndex + 1
  } of ${questions.length}`;

  feedback.textContent = "";
  //timer
  clearInterval(timer);
  timeLeft = 15;
  timerEl.textContent = timeLeft;

  timer = setInterval(() => {
    timeLeft--;
    timerEl.textContent = timeLeft;
    if (timeLeft === 0) {
      clearInterval(timer);
      displayAnswer(null);
    }
  }, 1000);

  const ques = questions[currentQuestionIndex];
  questionEl.textContent = ques.question;
  optionsEl.innerHTML = "";

  const answers = [...ques.incorrect_answers, ques.correct_answer].sort(
    () => Math.random() - 0.5
  );

  answers.forEach((answer) => {
    const button = document.createElement("button");
    button.textContent = answer;
    button.onclick = () => displayAnswer(answer);
    optionsEl.appendChild(button);
  });
}

function displayAnswer(selected) {
  clearInterval(timer);
  const ques = questions[currentQuestionIndex];

  document.querySelectorAll("#options button").forEach((button) => {
    if (button.textContent === ques.correct_answer) {
      button.classList.add("correct");
    } else {
      button.classList.add("incorrect");
    }
    button.disabled = true;
  });

  if (selected === ques.correct_answer) {
    feedback.textContent = `✅ Correct`;

    scores++;
    document.getElementById("current-score").textContent = scores;
  } else {
    feedback.textContent = ` ❌ Wrong! Correct answer: ${ques.correct_answer}`;
  }

  currentQuestionIndex++;
  setTimeout(moveToNextQuestion, 2000);
}

function endQuiz() {
  quizContainer.classList.add("hidden");
  endScreen.classList.remove("hidden");
  score.textContent = scores;
  restartBtn.classList.remove("hidden");

  // if (scores == questions.length) {
  // }

  confetti({
    particleCount: 300,
    spread: 150,
    origin: { y: 0.8 },
  });
}

startBtn.addEventListener("click", fetchData);

restartBtn.addEventListener("click", function () {
  // Reset quiz variables
  currentQuestionIndex = 0;
  scores = 0;
  document.getElementById("current-score").textContent = scores;
  feedback.textContent = "";
  optionsEl.innerHTML = "";
  questionEl.textContent = "";

  // Hide result screen and show the start screen
  endScreen.classList.add("hidden");
  startScreen.classList.remove("hidden");
  quizContainer.classList.add("hidden");
  restartBtn.classList.add("hidden");
  // fetch new questions
  questions = [];
  // fetchData();
});
