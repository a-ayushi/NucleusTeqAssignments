// Selecting elements

const player0El = document.querySelector(".player-0");
const player1El = document.querySelector(".player-1");
const score0El = document.getElementById("score-0");
const score1El = document.getElementById("score-1");
const current0El = document.getElementById("current-0");
const current1El = document.getElementById("current-1");
const name1 = document.getElementById("name-0");
const name2 = document.getElementById("name-1");

const diceEl = document.querySelector(".dice");
const btnNew = document.querySelector(".btn-new");
const btnRoll = document.querySelector(".btn-roll");
const btnHold = document.querySelector(".btn-hold");

let scores, currentScore, activePlayer, playing;

// starting conditions
const init = function () {
  scores = [0, 0];
  currentScore = 0;
  activePlayer = 0;
  playing = true;

  score0El.textContent = 0;
  score1El.textContent = 0;
  current0El.textContent = 0;
  current1El.textContent = 0;

  diceEl.classList.add("hidden");
  player0El.classList.remove("player-winner");
  player1El.classList.remove("player-winner");
  player0El.classList.add("player-active");
  player1El.classList.remove("player-active");

  // document.getElementById("name-0").value = "Player-1";
  // document.getElementById("name-1").value = "Player-2";

  if (!name1.value) name1.value = "Player-1";
  if (!name2.value) name2.value = "Player-2";

  name1.readOnly = false;
  name2.readOnly = false;
};

init();

// Disable name editing when the game starts
const disableNameEditing = function () {
  name1.readOnly = true;
  name2.readOnly = true;
};

// switchplayer
const switchPlayer = function () {
  document.getElementById(`current-${activePlayer}`).textContent = 0;
  currentScore = 0;
  activePlayer = activePlayer === 0 ? 1 : 0;
  player0El.classList.toggle("player-active");
  player1El.classList.toggle("player-active");
};

// rolling the dice
btnRoll.addEventListener("click", function () {
  if (playing) {
    //lock the player names when game starts
    disableNameEditing();

    // random dice roll
    const dice = Math.trunc(Math.random() * 6) + 1;

    //  display dice
    diceEl.classList.remove("hidden");
    diceEl.src = `dice-${dice}.jpg`;

    // check for 1
    if (dice != 1) {
      currentScore += dice;
      document.getElementById(`current-${activePlayer}`).textContent =
        currentScore;
    } else {
      switchPlayer();
    }
  }
});

// hold button

btnHold.addEventListener("click", function () {
  // 1. Add current score to active player's score
  if (playing) {
    scores[activePlayer] += currentScore;
    // scores[1] = scores[1] + currentScore

    document.getElementById(`score-${activePlayer}`).textContent =
      scores[activePlayer];

    //   check if score is >=100
    if (scores[activePlayer] >= 100) {
      playing = false;
      diceEl.classList.add("hidden");

      document
        .querySelector(`.player-${activePlayer}`)
        .classList.add(`player-winner`);
      document
        .querySelector(`.player-${activePlayer}`)
        .classList.remove("player-active");

      // winner player name displayed
      const winnerName = activePlayer === 0 ? name1.value : name2.value;

      Swal.fire({
        title: `${winnerName} Wins! 🏆`,
        text: "Congratulations!",
        icon: "success",
        confirmButtonText: "Play Again",
      }).then(() => {
        init(); // Restart game
      });
    } else {
      switchPlayer();
    }
  }
});

btnNew.addEventListener("click", init);
