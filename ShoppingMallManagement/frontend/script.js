const API_URL = "http://localhost:8082/api/shops";

const fields = ["shopId", "shopName", "shopCategory", "customers", "shopStatus", "leaseStatus"];
const buttons = ["addBtn", "searchBtn", "updateBtn", "deleteBtn"];


// =========================
// HELPERS
// =========================

function getShopFromForm() {
    return {
        shopId: Number(document.getElementById("shopId").value),
        shopName: document.getElementById("shopName").value,
        shopCategory: document.getElementById("shopCategory").value,
        customers: document.getElementById("customers").value,
        shopStatus: document.getElementById("shopStatus").value,
        leaseStatus: document.getElementById("leaseStatus").value
    };
}

function fillForm(data) {
    document.getElementById("shopId").value = data.shopId ?? "";
    document.getElementById("shopName").value = data.shopName ?? "";
    document.getElementById("shopCategory").value = data.shopCategory ?? "";
    document.getElementById("customers").value = data.customers ?? "";
    document.getElementById("shopStatus").value = data.shopStatus ?? "";
    document.getElementById("leaseStatus").value = data.leaseStatus ?? "";
    updatePreview();
}

function clearForm() {
    fields.forEach(id => document.getElementById(id).value = "");
    updatePreview();
}

function setBusy(isBusy) {
    buttons.forEach(id => document.getElementById(id).disabled = isBusy);
}

function showResult(message, type) {
    const box = document.getElementById("result");
    const cssClass = type ? "banner " + type : "banner";
    box.innerHTML = "<span class=\"" + cssClass + "\">" + message + "</span>";
}

function statusPillClass(value) {
    const v = (value || "").trim().toUpperCase();
    if (v === "OPEN") return "pill open";
    if (v === "CLOSED") return "pill closed";
    return "pill";
}

function leasePillClass(value) {
    const v = (value || "").trim().toUpperCase();
    if (v === "ACTIVE") return "pill active";
    if (v === "EXPIRED") return "pill expired";
    return "pill";
}

function updatePreview() {
    const shop = getShopFromForm();

    document.getElementById("previewId").textContent =
        shop.shopId ? "Shop #" + shop.shopId : "No ID set";
    document.getElementById("previewName").textContent =
        document.getElementById("shopName").value.trim() || "Unnamed shop";
    document.getElementById("previewCategory").textContent =
        document.getElementById("shopCategory").value.trim() || "Category not set";
    document.getElementById("previewCustomers").textContent =
        document.getElementById("customers").value.trim() || "\u2014";

    const statusEl = document.getElementById("previewStatus");
    statusEl.textContent = document.getElementById("shopStatus").value.trim() || "Status unknown";
    statusEl.className = statusPillClass(document.getElementById("shopStatus").value);

    const leaseEl = document.getElementById("previewLease");
    leaseEl.textContent = document.getElementById("leaseStatus").value.trim() || "Lease unknown";
    leaseEl.className = leasePillClass(document.getElementById("leaseStatus").value);
}

function pulsePlaque() {
    const plaque = document.getElementById("plaque");
    plaque.classList.remove("updated");
    // Force reflow so the animation can restart on repeated updates.
    void plaque.offsetWidth;
    plaque.classList.add("updated");
}

fields.forEach(id => {
    document.getElementById(id).addEventListener("input", updatePreview);
});
updatePreview();


// =========================
// ADD SHOP
// =========================
function addShop() {

    const shop = getShopFromForm();
    setBusy(true);

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(shop)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Failed to add shop");
        }
        return response.json();
    })
    .then(data => {
        showResult("Shop added successfully &mdash; " + data.shopName, "success");
        fillForm(data);
        pulsePlaque();
    })
    .catch(error => {
        showResult("Error: " + error.message, "error");
    })
    .finally(() => setBusy(false));
}


// =========================
// SEARCH SHOP
// =========================
function searchShop() {

    const id = document.getElementById("shopId").value;
    setBusy(true);

    fetch(API_URL + "/" + id)
        .then(response => {

            if (!response.ok) {
                throw new Error("Shop not found");
            }

            return response.json();
        })
        .then(data => {
            fillForm(data);
            showResult("Shop found successfully.", "success");
            pulsePlaque();
        })
        .catch(error => {
            showResult("Error: " + error.message, "error");
        })
        .finally(() => setBusy(false));
}


// =========================
// UPDATE SHOP
// =========================
function updateShop() {

    const shop = getShopFromForm();
    setBusy(true);

    fetch(API_URL, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(shop)
    })
    .then(response => {

        if (!response.ok) {
            throw new Error("Failed to update shop");
        }

        return response.json();
    })
    .then(data => {
        showResult("Shop updated successfully &mdash; " + data.shopName, "success");
        fillForm(data);
        pulsePlaque();
    })
    .catch(error => {
        showResult("Error: " + error.message, "error");
    })
    .finally(() => setBusy(false));
}


// =========================
// DELETE SHOP
// =========================
function deleteShop() {

    const id = document.getElementById("shopId").value;

    if (!confirm("Are you sure you want to delete this shop?")) {
        return;
    }

    setBusy(true);

    fetch(API_URL + "/" + id, {
        method: "DELETE"
    })
    .then(response => {

        if (!response.ok) {
            throw new Error("Shop not found or could not be deleted");
        }

        return response.text();
    })
    .then(message => {
        showResult(message, "success");
        clearForm();
    })
    .catch(error => {
        showResult("Error: " + error.message, "error");
    })
    .finally(() => setBusy(false));
}