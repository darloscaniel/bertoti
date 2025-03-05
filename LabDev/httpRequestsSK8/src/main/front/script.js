const getButton = document.getElementById("getButton");
const createButton = document.getElementById("createButton");
const editButton = document.getElementById("editButton");
const deleteButton = document.getElementById("deleteButton");

const getTab = document.getElementById("getTab");
const createTab = document.getElementById("createTab");
const editTab = document.getElementById("editTab");
const deleteTab = document.getElementById("deleteTab");

const listContent = document.getElementById("listContent");

const createBrand = document.getElementById("createBrand");
const createSize = document.getElementById("createSize");
const createImgUrl = document.getElementById("createImgUrl")
const createSubmit = document.getElementById("createSubmit");

const editSelect = document.getElementById("editSelect");
const editBrand = document.getElementById("editBrand");
const editSize = document.getElementById("editSize");
const editImg = document.getElementById("editImg")
const editSubmit = document.getElementById("editSubmit");

const deleteSelect = document.getElementById("deleteSelect");
const deleteSubmit = document.getElementById("deleteSubmit");

let boards = [];

function closeAllTabs(){
    getTab.classList.remove("active");
    createTab.classList.remove("active");
    editTab.classList.remove("active");
    deleteTab.classList.remove("active");
}

function disableCurrentButton(button) {
    getButton.disabled = false;
    createButton.disabled = false;
    editButton.disabled = false;
    deleteButton.disabled = false;
    button.disabled = true;
}

async function listBoards(){
    try{
        const response = await fetch("http://localhost:8080/boards");
        boards = await response.json();
        listContent.innerHTML = "";  // Limpar o conteúdo atual

        boards.forEach((board) => {
            const item = document.createElement("div");
            item.classList.add("board-item");

            const info = document.createElement("div");
            info.classList.add("board-info");

            // Verificar se a imagem existe e usar a URL para exibir a imagem
            const imageElement = document.createElement("img");
            imageElement.src = board.imgUrl || 'default-image.jpg';  // Adicionar uma imagem padrão caso a URL não exista
            imageElement.alt = `${board.brand} image`;
            imageElement.classList.add("board-image");

            // Adicionar a informação do board ao card
            info.innerHTML = `
             <strong>${board.brand}</strong>
             <span>tamanho: ${board.size}</span>
        `;

            item.appendChild(imageElement);  // Adiciona a imagem ao card
            item.appendChild(info);
            listContent.appendChild(item);
        });
    }catch (error){
        console.error("erro ao buscar dados: ", error)
    }
}


getButton.addEventListener("click", async function(){
    closeAllTabs();
    getTab.classList.add("active");
    disableCurrentButton(getButton);

    await listBoards();
});

createButton.addEventListener("click", function(){
    closeAllTabs();
    createTab.classList.add("active");
    disableCurrentButton(createButton);
});

createSubmit.addEventListener("click", async function(){
    const newBoard = {
        size: createSize.value,
        brand: createBrand.value,
        imgUrl: createImgUrl.value,
    };
    try {
        const response = await fetch("http://localhost:8080/boards", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(newBoard),
        });
        const data = await response.json();
        boards.push(data);
        createBrand.value = "";
        createSize.value = "";
        createImgUrl.value = "";
        alert("shape criado com sucesso!");
        await listBoards();
    }catch (error){
        console.error("erro ao criar shape!", error)
    }
});

editButton.addEventListener("click", async function() {
    closeAllTabs();
    editTab.classList.add("active");
    disableCurrentButton(editButton);

    editSelect.innerHTML = "";

    await listBoards();

    boards.forEach((board) => {
        const option = document.createElement("option");
        option.value = board.id;
        option.textContent = ` Marca: ${board.brand}`;
        editSelect.appendChild(option);
    });

    if (boards.length > 0) {
        editBrand.value = boards[0].brand;
        editSize.value = boards[0].size;
        editImg.value = boards[0].imgUrl;
    }
});

// Atualiza os campos ao selecionar um shape para editar
editSelect.addEventListener("change", function() {
    const selectedBoard = boards.find((board) => board.id == editSelect.value);
    if (selectedBoard) {
        editBrand.value = selectedBoard.brand;
        editSize.value = selectedBoard.size;
        editImg.value = selectedBoard.imgUrl;
    }
});



editSubmit.addEventListener("click", async function(){
    const selectedBoard  = editSelect.value;
    const updatedBoard = {
        size: editSize.value,
        brand: editBrand.value,
        imgUrl: editImg.value,
    };

    try{
        const response = await fetch(
            `http://localhost:8080/boards/${selectedBoard}`,
            {
                method: "PUT",
                headers: {
                    "Content-Type" : "application/json",
                },
                body: JSON.stringify(updatedBoard),
            }
        );
        const data = await response.json();
        const index = boards.findIndex((board) => board.id == selectedBoard);
        if (index !== -1) {
            boards[index] = data;
            alert("Shape editado com sucesso!");
            await listBoards();
        } else {
            console.error("Erro: Shape não encontrado para edição.");
        }
    } catch (error){
        console.error("Erro ao editar Shape!");
    }
});

deleteButton.addEventListener("click", async function(){
    closeAllTabs();
    deleteTab.classList.add("active");
    disableCurrentButton(deleteButton);
    deleteSelect.innerHTML = "";
    await listBoards();
    boards.forEach((board) => {
        const option = document.createElement("option");
        option.value = board.id;
        option.textContent = `ID: ${board.id} / Marca: ${board.brand}`;
        deleteSelect.appendChild(option);
    });
});

deleteSubmit.addEventListener("click", async function(){
    const selectedBoardID = deleteSelect.value;

    try{
        await fetch(`http://localhost:8080/boards/${selectedBoardID}`,{
            method: "DELETE",
        });
        boards = boards.filter((board) => board.id != selectedBoardID);
        alert("Shape deletado com sucesso!");
        await listBoards();
    }catch(error){
        console.error("erro ao deletar shape!", error);
    }
});