export default function AchievementCard() {
  return (
    <div className="flex flex-col p-4 rounded-2xl bg-[var(--secondary-color)] h-fit">
      <div className="flex justify-between">
        <div className="flex flex-col">
          <p className="font-bold text-2xl mt-1">Lochan Mathukumili</p>
          <p className="font-light text-lg mb-4">Student</p>
        </div>
        <span className="material-symbols-outlined">bookmark</span>
      </div>
      <img
        src={
          "https://cdn.hashnode.com/res/hashnode/image/upload/v1684574906816/95f6c7fe-6ef0-4761-978b-c29cea264b60.png?w=1600&h=840&fit=crop&crop=entropy&auto=compress,format&format=webp"
        }
        alt="Neeraj Chopra"
        className="w-full h-1/4 object-cover rounded-lg my-4"
      />
      <div>
        <p className="text-xl my-2 font-semibold">Smart Ideathon 2024</p>
        <p className="text-lg">App Development</p>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius rerum ad
          nemo odio corporis culpa a provident adipisci minima reprehenderit!
          Doloribus nobis aliquam voluptatem, quod placeat iure cumque quisquam
          alias!
        </p>
        <button className="bg-[var(--main-color)] text-white rounded-full px-4 py-2 w-full mt-4">
          View
        </button>
      </div>
      <div></div>
    </div>
  );
}
