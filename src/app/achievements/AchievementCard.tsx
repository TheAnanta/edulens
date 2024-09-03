export default function AchievementCard() {
  return (
    <div className="flex flex-col p-4 rounded-2xl bg-[var(--secondary-color)] h-fit">
      <div className="flex justify-between">
        <div className="flex flex-col">
          <p className="font-bold text-2xl mt-1">Neeraj Chopra</p>
          <p className="font-light text-lg mb-4">Alumni</p>
        </div>
        <span className="material-symbols-outlined">bookmark</span>
      </div>
      <img
        src={"https://github.com/psidh.png"}
        alt="Neeraj Chopra"
        className="w-full h-1/4 object-cover rounded-lg my-4"
      />
      <div>
        <p className="text-xl my-2">Gold Medal</p>
        <p className="text-lg">Atheletics</p>
        <p>
          Neeraj Chopra is an Indian track and field athlete. He is the first
          Indian to win a gold medal in track and field at the Olympics.
        </p>
        <button className="bg-[var(--main-color)] text-white rounded-full px-4 py-2 w-full mt-4">
          View
        </button>
      </div>
      <div>


      </div>
    </div>
  );
}
