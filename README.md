 # Islami App 📖🕌

**Islami** is a comprehensive Islamic app for Android built using **Kotlin**.  
The app provides the Holy Quran, Hadiths, and Sebha.

---

## 📱 App Pages

### 1️⃣ Quran Suras Page
- Displays a **list of all Quranic suras** with Arabic and English names and number of verses.
- Users can tap any sura to open its details page.
- **Technologies:**  
  - `RecyclerView` with `Adapter` to display the list of suras.
  - `ViewType` to differentiate between the **Header** and other items.

**Screenshot:**
 <img src="https://github.com/user-attachments/assets/352a23df-1dc6-409a-b1bd-85cf4e54a740" width="200" />

---

### 2️⃣ Chapter Details Page
- Shows **all verses** of the selected sura with verse numbers in Arabic numerals.
- Displays **Basmala** unless the sura is 1 or 9.
- Includes a **Back Button** to return to the list.
- **Technologies:**  
  - `RecyclerView` with a **Header** for the chapter title and verses as content.
  - Reads text files from `assets/quran/` for each sura.
  - Converts numbers to Arabic numerals.

**Screenshot:**

 <img src="https://github.com/user-attachments/assets/150cfcb7-cb67-4aca-b386-519155be16e5" width="200" />
 <img src="https://github.com/user-attachments/assets/8bb196ca-909c-4dbf-8a90-c028cd916d3b" width="200" />

---

### 3️⃣ Hadith Page
- Displays a **list of Prophetic Hadiths** with full text for each Hadith.
- Allows easy browsing and searching.
- **Technologies:**  
  - `RecyclerView` with **Adapter** to show the Hadiths.
  - Supports **Light & Dark Mode** for comfortable reading.

**Screenshot:**
<img src="https://github.com/user-attachments/assets/6455e516-765a-442e-a506-2328d78664db" width="200" />

---

### 4️⃣ Sebha Page
- Features an **interactive digital Sebha** with a counter.
- Counter increases on each tap.
- After **33 counts per dhikr**, automatically moves to the next dhikr in the list.
- **Reset Button** to reset the counter to zero.
- Includes **animation** when the Sebha is tapped.
- Displays the **current dhikr name** above the counter.
- **Technologies:**  
  - `FrameLayout` to overlay the number and dhikr name on the Sebha image.
  - `RotateAnimation` for Sebha rotation on tap.
  - `List<String>` for dhikr texts with automatic progression after 33 counts.

**Screenshot:**
<img src="https://github.com/user-attachments/assets/e4ef2bca-0a49-445f-a0fd-4dc8418c746b" width="200" />

---

