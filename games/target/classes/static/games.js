document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("game-form");
    const gameList = document.getElementById("game-list");
    let games = JSON.parse(localStorage.getItem("games")) || [];

    // إضافة لعبة
    if (form) {
        form.addEventListener("submit", function (e) {
            e.preventDefault();

            const title = document.getElementById("game-title").value;
            const type = document.getElementById("game-type").value;
            const desc = document.getElementById("game-desc").value;
            const rating = document.getElementById("game-rating").value;
            const image = document.getElementById("game-image").value;

            const newGame = { title, type, description: desc, rating, image };
            games.push(newGame);
            localStorage.setItem("games", JSON.stringify(games));

            // عرض رسالة نجاح
            alert("تم إضافة اللعبة بنجاح!");

            window.location.href = "games.html"; // إعادة التوجيه بعد الإضافة
        });
    }

    // عرض الألعاب
    if (gameList) {
        renderGames(games);
    }

    // دالة العرض
    function renderGames(gamesArray) {
        gameList.innerHTML = "";
        gamesArray.forEach((game, index) => {
            const gameItem = document.createElement("div");
            gameItem.classList.add("game-item");

            const stars = "★".repeat(game.rating) + "☆".repeat(5 - game.rating);

            gameItem.innerHTML = `
                <img src="${game.image}" alt="${game.title}" width="150">
                <h3>${game.title}</h3>
                <p>${game.type}</p>
                <div class="rating">${stars}</div>
                <button onclick="viewDetails(${index})" class="view-btn">👁 عرض</button>
                <button class="delete-btn" data-index="${index}">🗑 حذف</button>
            `;

            gameList.appendChild(gameItem);
        });

        // إضافة وظيفة الحذف
        document.querySelectorAll(".delete-btn").forEach(btn => {
            btn.addEventListener("click", function () {
                const index = this.getAttribute("data-index");
                games.splice(index, 1);
                localStorage.setItem("games", JSON.stringify(games));
                renderGames(games);
            });
        });
    }

    // الذهاب إلى صفحة التفاصيل
    window.viewDetails = function(index) {
        localStorage.setItem("selectedGame", index);
        window.location.href = "details.html";
    }
});




//


const games = [
  {
    id: "game1",
    name: "لعبة المغامرات",
    description: "تجربة مليئة بالإثارة والتشويق.",
    image: "images/game1.jpg"
  },
  {
    id: "game2",
    name: "لعبة الألغاز",
    description: "اختبر ذكائك مع ألغاز ممتعة.",
    image: "images/game2.jpg"
  }

 ];
 
 
