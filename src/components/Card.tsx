export default function Card(props: { title: string; attribute: string }) {
  return (
    <div className="bg-[var(--secondary-color)] p-6 w-full rounded-3xl flex items-center justify-between space-x-6">
      <div className="flex flex-col items-center justify-center w-16 h-16 rounded-full bg-[var(--main-color)] text-white">{props.title}</div>
      <div>
        <p className="text-lg">{props.title}</p>
        <p className="text-sm">{props.attribute}</p>
      </div>
    </div>
  );
}
